package leetCode._3100

object Solution_3071 {
  def minimumOperationsToWriteY(grid: Array[Array[Int]]): Int = {
    val diff = Array(Array(0, 1), Array(1, 0), Array(1, 2), Array(2, 1), Array(2, 0), Array(0, 2))
    val n = grid.length

    def f(Y: Int, notY: Int): Int = grid
      .indices
      .flatMap(i => grid
        .indices
        .withFilter(j => (((i <= n / 2 && (i == j || i + j == n - 1)) || (i > n / 2 && j == n / 2)) && Y != grid(i)(j)) ||
          (!((i <= n / 2 && (i == j || i + j == n - 1)) || (i > n / 2 && j == n / 2)) && notY != grid(i)(j)))
        .map(_ => 1))
      .sum

    diff.map(n => f(n.head, n(1))).min
  }
}
