package leetCode._2400

object Solution_2343 {
  def smallestTrimmedNumbers(nums: Array[String], queries: Array[Array[Int]]): Array[Int] = queries
    .map { case Array(k, trim) => nums
      .map(_.takeRight(trim))
      .zipWithIndex
      .sorted
      .apply(k - 1)
      ._2
    }
}
