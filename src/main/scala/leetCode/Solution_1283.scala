package leetCode

object Solution_1283 {
  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    var l = 0
    var r = 1000001
    while (l + 1 < r) {
      val m = (l + r) >>> 1
      var sum = 0
      nums.foreach(i => sum += (i + m - 1) / m)
      if (sum > threshold) l = m
      else r = m
    }
    r
  }
}
