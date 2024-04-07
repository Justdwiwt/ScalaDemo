package leetCode._300

import scala.collection.immutable.SortedSet

object Solution_239 {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(q: SortedSet[(Int, Int)], i: Int, acc: Seq[Int]): Seq[Int] = {
      lazy val newAcc = q.last._1 +: acc
      if (q.last._2 < i - k) f(q - q.last, i, acc)
      else if (i >= nums.length) newAcc
      else f(q + (nums(i) -> i), i + 1, newAcc)
    }

    f(SortedSet.empty[(Int, Int)] ++ nums.iterator.take(k).zipWithIndex, k, Nil).reverse.toArray
  }
}
