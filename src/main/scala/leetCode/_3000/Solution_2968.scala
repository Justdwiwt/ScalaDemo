package leetCode._3000

object Solution_2968 {
  def maxFrequencyScore(nums: Array[Int], k: Long): Int = {
    var s = 0L
    var res = 0
    var left = 0
    val sorted = nums.sorted
    sorted.indices.foreach(right => {
      s += sorted(right) - sorted((left + right) / 2)
      while (s > k) {
        s += sorted(left) - sorted((left + right + 1) / 2)
        left += 1
      }
      res = res.max(right - left + 1)
    })
    res
  }
}
