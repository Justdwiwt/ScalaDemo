package leetCode

object Solution_910 {
  def smallestRangeII(A: Array[Int], K: Int): Int = {
    val t = A.sorted
    var res = t(t.length - 1) - t(0)
    (0 until t.length - 1).foreach(i => {
      val a = t(i)
      val b = t(i + 1)
      val high = math.max(t(t.length - 1) - K, a + K)
      val low = math.min(t(0) + K, b - K)
      res = math.min(res, high - low)
    })
    res
  }
}
