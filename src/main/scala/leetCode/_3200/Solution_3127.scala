package leetCode._3200

object Solution_3127 {
  def canMakeSquare(grid: Array[Array[Char]]): Boolean = {
    def check(grid: Array[Array[Char]], i: Int, j: Int): Boolean = {
      val counts = (i to i + 1).flatMap(i1 => (j to j + 1).map(j1 => if (grid(i1)(j1) == 'B') 1 else 0))
      counts.sum <= 1 || counts.length - counts.sum <= 1
    }

    (0 to 1).exists(i => (0 to 1).exists(check(grid, i, _)))
  }
}
