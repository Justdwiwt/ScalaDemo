package leetCode._2800

object Solution_2780 {
  def minimumIndex(nums: List[Int]): Int = {
    val (x, f) = nums.groupBy(identity).mapValues(_.length).maxBy { case (_, f) => f }

    val n = nums.length

    nums
      .view
      .scanLeft(0)((cnt, n) => cnt + (if (n == x) 1 else 0)).tail
      .zipWithIndex
      .collectFirst { case (cnt, i) if cnt * 2 > (i + 1) && (f - cnt) * 2 > (n - i - 1) => i }
      .getOrElse(-1)
  }
}
