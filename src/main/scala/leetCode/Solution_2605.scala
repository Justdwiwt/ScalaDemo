package leetCode

object Solution_2605 {
  def minNumber(nums1: Array[Int], nums2: Array[Int]): Int =
    if ((nums1.toSet & nums2.toSet).nonEmpty) (nums1.toSet & nums2.toSet).toArray.min
    else (nums1.min.toString + nums2.min.toString).toInt.min((nums2.min.toString + nums1.min.toString).toInt)
}
