package leetCode._500

object Solution_463 {
  def islandPerimeter(grid: Array[Array[Int]]): Int = grid.zipWithIndex.map {
    case (row, rowIdx) => row.zipWithIndex.map {
        case (v, colIdx) => if (v == 1) {
          val left = if (colIdx != 0) grid(rowIdx)(colIdx - 1) ^ 1 else 1
          val up = if (rowIdx != 0) grid(rowIdx - 1)(colIdx) ^ 1 else 1
          val right = if (colIdx != grid.head.length - 1) grid(rowIdx)(colIdx + 1) ^ 1 else 1
          val down = if (rowIdx != grid.length - 1) grid(rowIdx + 1)(colIdx) ^ 1 else 1
          left + up + right + down
        } else 0
      }
      .sum
  }.sum
}
