package leetCode._700

import scala.collection.Searching.search

object Solution_611 {
  def triangleNumber(nums: Array[Int]): Int = {
    lazy val sorted = nums.toVector.sorted.dropWhile(_ == 0)

    @scala.annotation.tailrec
    def f(x: Int): Int =
      if (x < sorted.size && (sorted(x) == sorted(x - 1))) f(x - 1)
      else x

    (0 until (sorted.size - 2))
      .map(i => ((i + 1) until (sorted.size - 1))
        .map(j => f(sorted.search(sorted(i) + sorted(j)).insertionPoint) - j - 1).sum)
      .sum
      .max(0)
  }
}
