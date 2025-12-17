package leetCode._3700

import breeze.linalg.InjectNumericOps

object Solution_3634 {
  def minRemoval(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    val n = sorted.length

    val maxSave = sorted.indices.foldLeft((0, 0)) { case ((left, best), i) =>
      val newLeft = Iterator
        .iterate(left)(_ + 1)
        .dropWhile(sorted(_).toLong * k < sorted(i))
        .next()

      (newLeft, best.max(i - newLeft + 1))
    }._2

    n - maxSave
  }
}
