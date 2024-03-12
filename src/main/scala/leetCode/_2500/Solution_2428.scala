package leetCode._2500

object Solution_2428 {
  def maxSum(grid: Array[Array[Int]]): Int = (0 until (grid.length - 2))
    .flatMap(i => (0 until (grid.head.length - 2))
      .map(j => grid(i + 0)(j)
        + grid(i + 0)(j + 1)
        + grid(i + 0)(j + 2)
        + grid(i + 1)(j + 1)
        + grid(i + 2)(j)
        + grid(i + 2)(j + 1)
        + grid(i + 2)(j + 2)))
    .max
}
