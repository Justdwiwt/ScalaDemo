package leetCode._1800

object Solution_1759 {
  def countHomogenous(s: String): Int = {
    val M = (1e9 + 7).toInt
    var res = 0
    var len = 1L
    var last = s.head

    def f(): Unit = {
      val inc = (((len * (len + 1)) / 2) % M).toInt
      res = (res + inc) % M
    }

    s.view.drop(1).foreach(idx => {
      if (idx == last) len += 1
      else {
        f()
        len = 1L
        last = idx
      }
    })

    f()
    res
  }
}
