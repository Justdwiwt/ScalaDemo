package leetCode._3200

object Solution_3162 {
  def numberOfPairs(nums1: Array[Int], nums2: Array[Int], k: Int): Int =
    nums1.flatMap(i => nums2.filter(j => i % (j * k) == 0)).length
}
