package leetCode._3800

object Solution_3719 {
  def longestBalanced(nums: Array[Int]): Int = nums
    .indices
    .foldLeft(0)((max, i) => (i until nums.length)
      .foldLeft((Set.empty[Int], Set.empty[Int]), max) { case (((odds, evens), best), j) =>
        val num = nums(j)
        val sets = if (num % 2 == 1) (odds + num, evens) else (odds, evens + num)
        val newBest = if (sets._1.size == sets._2.size) math.max(best, j - i + 1) else best
        (sets, newBest)
      }
      ._2
    )
}