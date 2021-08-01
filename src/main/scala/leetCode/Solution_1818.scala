package leetCode

object Solution_1818 {
  val M = 1000000007

  def minAbsoluteSumDiff(nums1: Array[Int], nums2: Array[Int]): Int = {
    val sorted = nums1.sorted

    @scala.annotation.tailrec
    def findBefore(l: Int, r: Int, target: Int): Int =
      if (l > r) -1
      else if (sorted(r) <= target) r
      else {
        val mid = (l + r) >>> 1
        if (sorted(mid) <= target) findBefore(mid, r - 1, target)
        else findBefore(l, mid - 1, target)
      }

    var mx = 0
    var sum = 0
    nums1.zip(nums2).foreach({ case (num1, num2) =>
      val abs = (num1 - num2).abs
      sum = (sum + abs) % M
      val before = findBefore(0, sorted.length - 1, num2)
      if (before != -1) mx = mx.max(abs - (num2 - sorted(before)).abs)
      if (before != sorted.length - 1) mx = mx.max(abs - (num2 - sorted(before + 1)).abs)
    })

    val newDiff = sum - mx
    if (newDiff < 0) M + newDiff else newDiff
  }
}
