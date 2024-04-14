package leetCode.LCP

object LCP_76 {
  private def getNext(status: Int, cur: Char): Int = (cur, status) match {
    case ('B', 3) | ('B', 4) => -1
    case ('B', 1) | ('B', 5) => 4
    case ('B', 0) => 2
    case ('B', _) => 6
    case ('R', 5) | ('R', 6) => -1
    case ('R', 3) | ('R', 1) => 3
    case ('R', 0) => 1
    case ('R', _) => 5
    case _ => status
  }

  private def combine(status: Int, cb: Array[Char]): Int = {
    @scala.annotation.tailrec
    def f(x: Int, tt: Int, t2: Int, idx: Int): Int =
      if (idx == cb.length) t2
      else {
        val c = x % 7
        val t = getNext(c, cb(idx))
        if (t < 0) -1
        else f(x / 7, tt * 7, t2 + t * tt, idx + 1)
      }

    f(status, 1, 0, 0)
  }

  def getSchemeCount(_n: Int, _m: Int, chessboard: Array[String]): Long = {
    val cb = Array.ofDim[Char](40, 40)
    var m = _m
    var n = _n
    if (m > n) {
      (0 until m).foreach(i => (0 until n).foreach(j => cb(i)(j) = chessboard(j).charAt(i)))
      val temp = n
      n = m
      m = temp
    } else (0 until n).foreach(i => (0 until m).foreach(j => cb(i)(j) = chessboard(i).charAt(j)))

    var curMap = Map(0 -> 1L)
    val stpMap = Array('R', 'B', '.')

    (0 until n).foreach(i => {
      val curCb = Array.ofDim[Char](m)
      val ind = Array.ofDim[Int](m)
      var cou = 0
      var t = 1
      val newMap = collection.mutable.Map.empty[Int, Long]

      (0 until m).foreach(j => {
        curCb(j) = cb(i)(j)
        if (cb(i)(j) == '?') {
          ind(cou) = j
          t *= 3
          cou += 1
        }
      })

      (0 until t).foreach(j => {
        var x = j
        (0 until cou).foreach(k => {
          curCb(ind(k)) = stpMap(x % 3)
          x /= 3
        })
        var l1 = '.'
        var l2 = '.'
        var legal = true
        (0 until m).foreach(k => if (curCb(k) == 'R' || curCb(k) == 'B') {
          if (l1 != '.' && curCb(k) != l1) legal = false
          l1 = l2
          l2 = curCb(k)
        })
        if (legal) curMap.foreach { case (ttt, value) =>
          val tgt = combine(ttt, curCb)
          if (tgt >= 0) newMap(tgt) = newMap.getOrElse(tgt, 0L) + value
        }
      })
      curMap = newMap.toMap
    })
    curMap.values.sum
  }
}
