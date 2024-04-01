package leetCode._900

object Solution_807 {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    val leftRight = grid.map(_.max)
    val topBottom = grid.head.indices.map(i => grid.map(_(i)).max).toArray
    grid.zipWithIndex.map { case (line, lineIndex) => line
      .zipWithIndex.map { case (buildingHeight, columnIndex) =>
        leftRight(lineIndex).min(topBottom(columnIndex)) - buildingHeight
      }.sum
    }.sum
  }
}
