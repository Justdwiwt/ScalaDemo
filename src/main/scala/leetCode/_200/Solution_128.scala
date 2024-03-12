package leetCode._200

import scala.collection.immutable.HashSet

object Solution_128 {
  @scala.annotation.tailrec
  def findLongestStreak(st: Set[Int], cur: Int, streak: Int = 1): Int =
    if (st.contains(cur + 1)) findLongestStreak(st - (cur + 1), cur + 1, streak + 1)
    else streak

  def longestConsecutive(nums: Array[Int]): Int =
    if (nums.isEmpty) 0
    else {
      val st = HashSet() ++ nums
      val num = nums.filter(number => !st.contains(number - 1))
      num.map(findLongestStreak(st, _)).max
    }
}
