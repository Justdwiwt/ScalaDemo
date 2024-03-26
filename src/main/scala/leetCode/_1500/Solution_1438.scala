package leetCode._1500

import scala.collection.immutable.SortedSet

object Solution_1438 {
  def longestSubarray(nums: Array[Int], limit: Int): Int = {
    @scala.annotation.tailrec
    def f(lo: Int, hi: Int, set: Set[(Int, Int)], acc: Int): Int = {
      lazy val ((mn, imn), tmn) = set.head -> set.tail
      lazy val ((mx, imx), tmx) = set.last -> set.init
      if (hi >= nums.length) acc
      else if (set.isEmpty) f(lo, lo + 1, set + (nums(lo) -> lo), acc)
      else if (imn < lo) f(lo, hi, tmn, acc)
      else if (imx < lo) f(lo, hi, tmx, acc)
      else if (mx - limit > nums(hi) || mn + limit < nums(hi)) f(lo + 1, hi, set, acc)
      else f(lo, hi + 1, set + (nums(hi) -> hi), acc.max(hi - lo + 1))
    }

    f(0, 1, SortedSet(nums.head -> 0)(Ordering[(Int, Int)].on(x => (x._1, -x._2))), 1)
  }
}
