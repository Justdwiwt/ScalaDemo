package leetCode._1400

object Solution_1351 {
  def countNegatives(grid: Array[Array[Int]]): Int = {
    grid.flatten.count(_ < 0)
  }
}
