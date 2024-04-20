package leetCode._2500

object Solution_2422 {
  def minimumOperations(nums: Array[Int]): Int = {
    var left = 0
    val n = nums.length
    var right = n - 1
    var diff = 0L
    var op = 0
    while (left <= right) {
      if (diff != 0L) op += 1
      var change = 0L
      if (diff <= 0L) {
        change += nums(left)
        left += 1
      }
      if (diff >= 0L) {
        change -= nums(right)
        right -= 1
      }
      diff += change
    }
    if (diff != 0L) op += 1
    op
  }
}
