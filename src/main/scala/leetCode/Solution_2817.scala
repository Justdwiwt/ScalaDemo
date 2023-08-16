package leetCode

import scala.collection.immutable.TreeSet

object Solution_2817 {
  def minAbsoluteDifference(nums: List[Int], x: Int): Int = nums
    .zip(nums.drop(x))
    ./:((TreeSet.empty[Int], Int.MaxValue))(f)
    ._2

  private def f(state: (TreeSet[Int], Int), elem: (Int, Int)): (TreeSet[Int], Int) = {
    val ((set, min), (left, right)) = (state, elem)
    val nSet = set + left
    val diffs = List(nSet.maxBefore(right), nSet.minAfter(right)).flatten.map(n => (right - n).abs)
    (nSet, (min :: diffs).min)
    null
  }
}
