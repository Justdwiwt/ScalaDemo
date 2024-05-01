package leetCode._1200

object Solution_1150 {
  def isMajorityElement(nums: Array[Int], target: Int): Boolean =
    nums.count(_ == target) > nums.length / 2
}
