package leetCode._1300

object Solution_1260 {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = {
    val (num, cols) = (grid.flatten, grid.head.length)
    val (tail, head) = num.splitAt(num.length - k % num.length)
    (head ++ tail).grouped(cols).map(_.toList).toList
  }
}
