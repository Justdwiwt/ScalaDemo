package leetCode._3100

object Solution_3077 {
  def maximumStrength(nums: Array[Int], k: Int): Long = {
    val n = nums.length
    val a = Array.fill(n + 1)(0L)
    val b = Array.fill(n + 1)(0L)
    nums.indices.foreach(i => a(i + 1) = a(i) + nums(i))
    (1 to k).foreach(i => {
      var pre = b(i - 1)
      b(i - 1) = Long.MinValue
      var mx = Long.MinValue
      val w = (k - i + 1) * (if (i % 2 > 0) 1 else -1)
      (i to n - k + i).foreach(j => {
        mx = mx.max(pre - a(j - 1) * w)
        pre = b(j)
        b(j) = b(j - 1).max(a(j) * w + mx)
      })
    })
    b(n)
  }
}
