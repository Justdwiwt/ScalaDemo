package leetCode

object Solution_1708 {
  def largestSubarray(nums: Array[Int], k: Int): Array[Int] = {
    var mx = 0
    var idx = 0
    (0 until nums.length - k + 1).foreach(i => if (nums(i) > mx) {
      mx = nums(i)
      idx = i
    })
    java.util.Arrays.copyOfRange(nums, idx, idx + k)
  }
}
