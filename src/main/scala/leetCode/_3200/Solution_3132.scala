package leetCode._3200

object Solution_3132 {
  def minimumAddedInteger(nums1: Array[Int], nums2: Array[Int]): Int = {
    val nums1Sorted = nums1.sorted
    val nums2Sorted = nums2.sorted

    @scala.annotation.tailrec
    def findDiff(diff: Int, i: Int, j: Int): Boolean =
      if (j >= nums2.length) true
      else if (i >= nums1.length) false
      else if (nums1Sorted(i) + diff == nums2Sorted(j)) findDiff(diff, i + 1, j + 1)
      else findDiff(diff, i + 1, j)

    @scala.annotation.tailrec
    def findMinDiff(i: Int): Int = {
      val diff = nums2Sorted.head - nums1Sorted(i)
      if (findDiff(diff, i, 0)) diff
      else findMinDiff(i - 1)
    }

    findMinDiff(2)
  }
}
