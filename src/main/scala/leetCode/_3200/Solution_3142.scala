package leetCode._3200

object Solution_3142 {
  def satisfiesConditions(grid: Array[Array[Int]]): Boolean = grid
    .transpose
    .map(_.toSet.size)
    .forall(_ == 1) && grid
    .head
    .zip(grid.head.drop(1))
    .map(n => n._1 - n._2)
    .count(_ == 0) == 0
}
