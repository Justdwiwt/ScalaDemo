package leetCode._3900

import scala.collection.Searching.search

object Solution_3825 {
  def longestSubsequence(nums: Array[Int]): Int = {
    val maxVal = if (nums.isEmpty) 0 else nums.max
    val w = 32 - Integer.numberOfLeadingZeros(maxVal)

    (0 until w)
      .map(1 << _)
      .map(bit => {
        nums.foldLeft(Vector.empty[Int])((lis, x) => {
          if ((x & bit) == 0) lis
          else {
            val i = lis.search(x).insertionPoint
            if (i < lis.length) lis.updated(i, x)
            else lis :+ x
          }
        }).length
      })
      .foldLeft(0)(_.max(_))
  }
}
