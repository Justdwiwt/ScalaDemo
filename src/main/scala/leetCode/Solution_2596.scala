package leetCode

object Solution_2596 {
  private final val diff: Seq[Seq[Int]] = Seq(
    Seq(-1, -2), Seq(1, -2),
    Seq(-2, -1), Seq(2, -1),
    Seq(-2, 1), Seq(2, 1),
    Seq(-1, 2), Seq(1, 2)
  )

  private def isValid(grid: Array[Array[Int]], x: Int, y: Int, expectedPos: Int): Boolean = {
    if (x >= grid.length || y >= grid.head.length || x < 0 || y < 0 || grid(x)(y) != expectedPos) return false
    if (expectedPos == grid.length * grid.head.length - 1) return true
    diff.exists(delta => isValid(grid, x + delta.head, y + delta(1), expectedPos + 1))
  }

  def checkValidGrid(grid: Array[Array[Int]]): Boolean =
    isValid(grid, 0, 0, 0)
}
