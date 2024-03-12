package leetCode._2900

import scala.collection.mutable

object Solution_2856 {
  def minLengthAfterRemovals(nums: List[Int]): Int = {
    val m = mutable.HashMap.empty[Int, Int]
    nums.foreach(num => m += num -> (m.getOrElse(num, 0) + 1))
    val mx = m.values.max
    val n = nums.length
    (n & 1).max((mx << 1) - n)
  }
}
