package leetCode

object Solution_3034 {
  def countMatchingSubarrays(nums: Array[Int], pattern: Array[Int]): Int = {
    var cnt = 0
    val n = nums.length
    val m = pattern.length
    var i = 0
    var j = m - 1
    while (j < n - 1) {
      var flag = true
      var k = 0
      while (k < m && flag) {
        val diff = nums(i + k + 1) - nums(i + k)
        val cur = getPattern(diff)
        if (cur != pattern(k)) flag = false
        k += 1
      }
      if (flag) cnt += 1
      i += 1
      j += 1
    }
    cnt
  }

  private def getPattern(diff: Int): Int =
    if (diff == 0) 0
    else if (diff > 0) 1
    else -1
}
