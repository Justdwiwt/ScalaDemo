package leetCode._3100

object Solution_3036 {
  def countMatchingSubarrays(nums: Array[Int], pattern: Array[Int]): Int = {
    val n = nums.length
    val m = pattern.length
    val info = Array.fill(n - 1)(0)
    nums.indices.dropRight(1).foreach(i => {
      if (nums(i) < nums(i + 1)) info(i) = 1
      else if (nums(i) > nums(i + 1)) info(i) = -1
      else info(i) = 0
    })
    val newNums = Array.fill(n + m - 1)(0)
    pattern.indices.foreach(i => newNums(i) = pattern(i))
    (m until n + m - 1).foreach(i => newNums(i) = info(i - m))
    val z = Array.fill(n + m - 1)(0)
    var l, r = 0
    (1 until n + m - 1).foreach(i => {
      if (i <= r) z(i) = z(i - l).min(r - i + 1)
      while (i + z(i) < n + m - 1 && newNums(z(i)) == newNums(i + z(i))) {
        l = i
        r = i + z(i)
        z(i) += 1
      }
    })
    (m until n + m - 1).count(i => z(i) >= m)
  }
}
