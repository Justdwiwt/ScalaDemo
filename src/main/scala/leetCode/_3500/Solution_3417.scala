package leetCode._3500

object Solution_3417 {
  def zigzagTraversal(grid: Array[Array[Int]]): List[Int] = {
    val m = grid.head.length
    grid.zipWithIndex.flatMap { case (row, i) =>
      if (i % 2 == 0) row.indices.collect { case j if (i * m + j) % 2 == 0 => row(j) }
      else row.indices.reverse.collect { case j if (i * m + (m - 1 - j)) % 2 == 0 => row(j) }
    }.toList
  }
}
