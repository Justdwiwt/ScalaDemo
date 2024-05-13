package leetCode._3200

object Solution_3148 {
  def maxScore(grid: List[List[Int]]): Int = {
    val INF = Int.MaxValue
    val m = grid.length
    val n = grid.headOption.map(_.length).getOrElse(0)
    val arr = Array.fill(m + 1, n + 1)(INF)

    grid
      .zipWithIndex
      .flatMap { case (row, i) =>
        row.zipWithIndex.map { case (x, j) =>
          val mn = List(arr(i + 1)(j), arr(i)(j + 1)).min
          val score = x - mn
          arr(i + 1)(j + 1) = mn.min(x)
          score
        }
      }
      .max
  }
}
