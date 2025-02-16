package leetCode._3500

object Solution_3446 {
  def sortMatrix(grid: Array[Array[Int]]): Array[Array[Int]] = {
    (grid
      .indices
      .reverse
      .toList
      .map(r => List.range(0, grid.length - r).map(c => (r + c, c))) ++ grid
      .indices
      .toList
      .drop(1)
      .map(c => List.range(0, grid.length - c).map(r => (r, c + r))))
      .foreach(diag => diag
        .map { case (r, c) => grid(r)(c) -> (r, c) }
        .sortBy { case (x, (r, c)) => ((math.signum(c - r) * 2).max(0) - 1) * x }
        .map(_._1)
        .zip(diag)
        .foreach { case (x, (r, c)) => grid(r)(c) = x }
      )
    grid
  }
}
