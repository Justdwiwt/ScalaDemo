package leetCode._800

object Solution_760 {
  def anagramMappings(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    nums1.map(nums2.indexOf(_))
}
