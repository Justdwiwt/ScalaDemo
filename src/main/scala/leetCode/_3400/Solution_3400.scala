package leetCode._3400

object Solution_3400 {
  def maximumMatchingIndices(nums1: Array[Int], nums2: Array[Int]): Int = {
    def check(nums1: Array[Int], nums2: Array[Int]): Int =
      nums1.zip(nums2).count { case (a, b) => a == b }

    def rotateArray(arr: Array[Int], k: Int): Array[Int] = {
      val len = arr.length
      arr.drop(len - k) ++ arr.take(len - k)
    }

    nums1.indices.map(i => check(rotateArray(nums1, i), nums2)).max
  }
}
