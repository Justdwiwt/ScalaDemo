package leetCode

object Solution_954 {
  def canReorderDoubled(arr: Array[Int]): Boolean = {
    val M = 100000
    val pos = Array.fill(M + 1)(0)
    val neg = Array.fill(M + 1)(0)
    var cnt = 0
    arr.foreach(v => {
      if (v > 0) pos(v) += 1
      else if (v < 0) neg(-v) += 1
      else cnt += 1
    })
    if ((cnt & 1) == 1) return false
    (1 until M).foreach(i => {
      if (pos(i) > 0)
        if (i * 2 > M || pos(i * 2) < pos(i)) return false
        else pos(i * 2) -= pos(i)
      if (neg(i) > 0)
        if (i * 2 > M || neg(i * 2) < neg(i)) return false
        else neg(i * 2) -= neg(i)
    })
    true
  }
}
