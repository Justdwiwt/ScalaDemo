package leetCode._2100

import scala.collection.Searching.search

object Solution_2035 {
  def minimumDifference(nums: Array[Int]): Int = {
    val n = nums.length / 2
    val (l, r) = nums.splitAt(n)
    val (lSum, rSum) = (l.sum, r.sum)
    var minDiff = Int.MaxValue
    (0 to n / 2).foreach(i => {
      val leftDiffs = l.combinations(i).map(_.sum * 2 - lSum).toArray.sorted
      r.combinations(n - i).foreach(rightCombo => {
        val targetDiff = 2 * rightCombo.sum - rSum
        val leftDiffIdx = leftDiffs.search(-targetDiff).insertionPoint
        if (leftDiffIdx > 0)
          minDiff = minDiff.min((leftDiffs(leftDiffIdx - 1) + targetDiff).abs)
        if (leftDiffIdx < leftDiffs.length)
          minDiff = minDiff.min((leftDiffs(leftDiffIdx) + targetDiff).abs)
      })
    })
    minDiff
  }
}
