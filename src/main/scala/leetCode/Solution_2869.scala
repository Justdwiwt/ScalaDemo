package leetCode

import scala.collection.mutable

object Solution_2869 {
  def minOperations(nums: List[Int], k: Int): Int = {
    val set = mutable.Set.empty[Int]

    @scala.annotation.tailrec
    def f(rs: List[Int], res: Int): Int = {
      if (set.size == k) return res
      if (rs.head <= k) set.add(rs.head)
      f(rs.tail, res + 1)
    }

    f(nums.reverse, 0)
  }
}
