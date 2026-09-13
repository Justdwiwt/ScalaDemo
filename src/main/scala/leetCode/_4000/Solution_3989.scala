package leetCode._4000

object Solution_3989 {
  def maxConsistentColumns(grid: Array[Array[Int]], limit: Int): Int = {
    val n = grid.head.length

    grid.head.indices.foldLeft(Array.fill(n)(0)) { (f, i) =>
      f(i) = 1 + (0 until i)
        .filter(j => grid.forall(row => (row(i) - row(j)).abs <= limit))
        .map(f)
        .foldLeft(0)(math.max)
      f
    }.max
  }
}
