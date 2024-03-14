package leetCode._2800

import scala.collection.mutable

object Solution_2771 {
  def maxNonDecreasingLength(nums1: Array[Int], nums2: Array[Int]): Int = {
    val m = mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, pre: Int): Int = m.getOrElseUpdate((i, pre),
      if (i == nums1.length) 0
      else if (pre == 0) dfs(i + 1, 0).max(1 + dfs(i + 1, 1)).max(1 + dfs(i + 1, 2))
      else {
        val prevTarget = if (pre == 1) nums1(i - 1) else nums2(i - 1)
        Seq((nums1(i), 1), (nums2(i), 2))
          .collect { case (n, arr) if n >= prevTarget => 1 + dfs(i + 1, pre = arr) }
          .max
        //          .getOrElse(0)
      })

    dfs(0, 0)
  }
}
