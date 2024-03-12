package leetCode._500

object Solution_496 {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = nums1
    .map(num => nums2
      .drop(nums2.indexOf(num) + 1)
      .find(_ > num)
      .getOrElse(-1))
}
