package leetCode.LCP

object LCP_32 {
  def processTasks(tasks: Array[Array[Int]]): Int = {
    var segs = Array.empty[Array[Int]]
    var pre = Array.emptyIntArray

    pre :+= 0

    val sorted = tasks.sorted((a: Array[Int], b: Array[Int]) => if (a(1) != b(1)) a(1) - b(1) else b(2) - a(2))

    sorted.foreach(t => {
      val need = t(2) - query(t.head, t(1))
      if (need > 0) push(need, t(1))
    })

    def query(l: Int, r: Int): Int = {
      val start = binS(l)
      val res = pre(pre.length - 1) - pre(start)
      if (res != 0 && l > segs(start).head) res - l + segs(start).head
      else res
    }

    def binS(tar: Int): Int = {
      var l = 0
      var r = segs.length - 1
      var res = segs.length
      while (l <= r) {
        val mid = (l + r) >>> 1
        if (segs(mid)(1) >= tar) {
          res = mid
          r = mid - 1
        } else l = mid + 1
      }
      res
    }

    def push(need: Int, r: Int): Unit = {
      var t = need
      while (true) {
        if (segs.isEmpty || r - segs(segs.length - 1)(1) > t) {
          pre :+= (pre(pre.length - 1) + t)
          segs :+= Array(r - t + 1, r)
          return
        } else {
          t += segs(segs.length - 1)(1) - segs(segs.length - 1).head + 1
          segs.drop(segs.length - 1)
          pre.drop(pre.length - 1)
        }
      }
    }

    pre(pre.length - 1)
  }
}
