package leetCode._3300

object Solution_3231 {
  def minOperations(nums: Array[Int]): Int = {
    val n = nums.length
    val endNums = Array.fill(n + 1)(Int.MinValue)
    endNums(0) = Int.MaxValue
    var maxLength = 1

    nums.foreach(num => {
      var (low, high) = (1, maxLength + 1)
      while (low < high) {
        val mid = low + (high - low) / 2
        if (endNums(mid) < num) high = mid
        else low = mid + 1
      }
      endNums(low) = num
      maxLength = maxLength.max(low)
    })

    maxLength
  }
}
