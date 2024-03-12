package leetCode._2700

object Solution_2639 {
  def findColumnWidth(grid: Array[Array[Int]]): Array[Int] =
    grid.transpose.map(_.map(_.toString.length).max)
}
