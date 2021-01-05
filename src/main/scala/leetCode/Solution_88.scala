package leetCode

object Solution_88 {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    val arr = (nums1.take(m) ++ nums2.take(n)).sorted
    arr.indices.foreach(i => nums1(i) = arr(i))
  }
}
