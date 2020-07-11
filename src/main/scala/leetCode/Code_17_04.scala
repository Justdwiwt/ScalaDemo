package leetCode

object Code_17_04 {
  def missingNumber(nums: Array[Int]): Int = {
    (0 to nums.length).sum - nums.sum
  }
}
