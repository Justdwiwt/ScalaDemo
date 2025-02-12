package leetCode._3500

object Solution_3446 {
  def sortMatrix(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val m = grid.length
    val n = grid.head.length

    (1 until m + n).foldLeft(grid)((cur, k) => {
      val minJ = 0.max(n - k)
      val maxJ = (n - 1).min(m + n - 1 - k)

      val a = (minJ to maxJ).map(j => cur(k + j - n)(j)).sorted(if (minJ == 0) Ordering.Int.reverse else Ordering.Int)

      (minJ to maxJ).zip(a).foldLeft(cur)((updatedGrid, tuple) => {
        val (j, value) = tuple
        updatedGrid.updated(k + j - n, updatedGrid(k + j - n).updated(j, value))
      })
    })
  }
}
