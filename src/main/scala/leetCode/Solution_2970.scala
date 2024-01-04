package leetCode

object Solution_2970 {
  def incremovableSubarrayCount(nums: Array[Int]): Int = {
    val n = nums.length
    var i = 0
    while (i < n - 1 && nums(i) < nums(i + 1)) i += 1
    if (i == n - 1) return n * (n + 1) / 2
    var res = i + 2
    var j = n - 1
    while (j == n - 1 || nums(j) < nums(j + 1)) {
      while (i >= 0 && nums(i) >= nums(j)) i -= 1
      res += i + 2
      j -= 1
    }
    res
  }
}
