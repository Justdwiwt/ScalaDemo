package leetCode._800

object Solution_718 {
  def findLength(nums1: Array[Int], nums2: Array[Int]): Int = {
    val arr = Array.ofDim[Int](nums1.length + 1, nums2.length + 1)
    ((nums1.length - 1) to(0, -1))
      .foreach(i => ((nums2.length - 1) to(0, -1))
        .foreach(j => if (nums1(i) == nums2(j)) arr(i)(j) = arr(i + 1)(j + 1) + 1))
    arr.flatten.max
  }
}
