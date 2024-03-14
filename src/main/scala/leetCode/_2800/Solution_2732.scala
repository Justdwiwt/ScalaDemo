package leetCode._2800

object Solution_2732 {
  def goodSubsetofBinaryMatrix(grid: Array[Array[Int]]): List[Int] = {
    val rowValue = grid.map(row => grid.head.indices.foldLeft(0)((acc, j) => acc | (row(j) << j)))

    grid
      .indices
      .view
      .collectFirst { case i if rowValue(i) == 0 => List(i) }
      .orElse(grid
        .indices
        .view
        .flatMap(i => (i + 1 until grid.length).map((i, _)))
        .collectFirst { case (i, j) if (rowValue(i) & rowValue(j)) == 0 => List(i, j) })
      .getOrElse(Nil)
  }
}
