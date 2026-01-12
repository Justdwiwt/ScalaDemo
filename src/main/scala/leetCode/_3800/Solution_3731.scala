package leetCode._3800

object Solution_3731 {
  def findMissingElements(nums: Array[Int]): List[Int] = nums
    .min
    .to(nums.max)
    .diff(nums)
    .toList
}
