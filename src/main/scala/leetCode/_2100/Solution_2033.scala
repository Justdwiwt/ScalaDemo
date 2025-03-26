package leetCode._2100

object Solution_2033 {
  def minOperations(grid: Array[Array[Int]], x: Int): Int = {
    val flatGrid = grid.flatten.sorted
    val median = flatGrid(flatGrid.length / 2)
    if (flatGrid.exists(v => (v - median) % x != 0)) -1
    else flatGrid.map(v => (v - median).abs / x).sum
  }
}
