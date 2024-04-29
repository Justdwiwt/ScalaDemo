package leetCode._3200

object Solution_3128 {
  def numberOfRightTriangles(grid: Array[Array[Int]]): Long = {
    val lr = grid.map(_.sum - 1L)
    val lc = grid.transpose.map(_.sum - 1L)
    grid.indices.flatMap(i => grid.head.indices.withFilter(grid(i)(_) == 1).map(lr(i) * lc(_))).sum
  }
}
