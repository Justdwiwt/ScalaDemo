package leetCode._500

object Solution_410 {
  def splitArray(nums: Array[Int], m: Int): Int = {
    def canSplit(sumLimit: Int): Boolean = nums
      .foldLeft((1, 0)) { case ((subarrayCount, currentSum), n) =>
        if (currentSum + n <= sumLimit) (subarrayCount, currentSum + n)
        else (subarrayCount + 1, n)
      }
      ._1 <= m

    @scala.annotation.tailrec
    def binarySearch(l: Int, r: Int): Int =
      if (l >= r) l
      else {
        val mid = (l + r) >>> 1
        if (canSplit(mid)) binarySearch(l, r = mid)
        else binarySearch(l = mid + 1, r)
      }

    binarySearch(l = nums.max, r = nums.sum)
  }
}
