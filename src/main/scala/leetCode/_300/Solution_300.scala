package leetCode._300

import scala.collection.Searching.search

object Solution_300 {
  def lengthOfLIS(nums: Array[Int]): Int = nums
    .foldLeft(Seq.fill(nums.length + 1)(Int.MaxValue)) { case (monoStack, n) => monoStack.updated(monoStack.search(n).insertionPoint, n) }
    .indexWhere(_ == Int.MaxValue)
}
