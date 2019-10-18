package leetCode

object Solution_287 {
  def findDuplicate(nums: Array[Int]): Int = {
    if (nums.length > 1) {
      var slow = nums(0)
      var fast = nums(nums(0))
      while (slow != fast) {
        slow = nums(slow)
        fast = nums(nums(fast))
      }
      fast = 0
      while (fast != slow) {
        fast = nums(fast)
        slow = nums(slow)
      }
      return slow
    }
    -1
  }
}
