package leetCode._4000

object Solution_3938 {
  @inline
  private def fmax(a: Int, b: Int): Int =
    if (b > a) b else a

  private def maxSubArray(nums: Array[Int]): Int =
    nums.tail.foldLeft((Int.MinValue, nums.head)) {
      case ((ans, f), x) => (fmax(ans, f + x), fmax(f, 0) + x)
    }._1

  def maxScore(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length

    val single =
      if (m > 2 && n > 2) grid
        .slice(1, m - 1)
        .iterator
        .map(_.slice(1, n - 1).max)
        .max
      else
        Int.MinValue

    val rowAns = grid.iterator.map(maxSubArray).max

    val colAns = (0 until n)
      .iterator
      .map(j => maxSubArray(Array.tabulate(m)(grid(_)(j))))
      .max

    Seq(single, rowAns, colAns).max
  }
}
