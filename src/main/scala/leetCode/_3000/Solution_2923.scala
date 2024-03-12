package leetCode._3000

object Solution_2923 {
  def findChampion(grid: Array[Array[Int]]): Int =
    grid.indexWhere(_.sum == grid.length - 1)
}
