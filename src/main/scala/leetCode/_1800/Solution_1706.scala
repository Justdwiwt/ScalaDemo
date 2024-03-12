package leetCode._1800

object Solution_1706 {
  def findBall(grid: Array[Array[Int]]): Array[Int] = {
    if (grid.isEmpty) Array.empty[Int]
    else {
      val res = Array.fill(grid.head.length)(0)
      val m = Map.empty[(Int, Int), Int]
      val _ = grid.head.indices./:(m) { case (p, i) =>
        val (resCol, updated) = f(0, i, None, Nil, grid, p, grid.length, grid.head.length)
        res(i) = resCol
        updated
      }
      res
    }
  }

  @scala.annotation.tailrec
  def f(row: Int, col: Int, pre: Option[(Int, Int)], step: List[(Int, Int)], grid: Array[Array[Int]], m: Map[(Int, Int), Int], rowBoundary: Int, colBoundary: Int): (Int, Map[(Int, Int), Int]) = {
    if (row == rowBoundary) (col, m)
    else if (col < 0 || col == colBoundary) (-1, m)
    else m.get((row, col)) match {
      case Some(resCol) => (resCol, m)
      case None =>
        val cur = grid(row)(col)
        pre match {
          case Some((pr, pc)) if cur == grid(pr)(pc) => f(row + 1, col, None, step, grid, m, rowBoundary, colBoundary)
          case Some((_, _)) => (-1, m)
          case None =>
            if (cur == 1) f(row, col + 1, Some(row, col), (row, col) :: step, grid, m, rowBoundary, colBoundary)
            else f(row, col - 1, Some(row, col), (row, col) :: step, grid, m, rowBoundary, colBoundary)
        }
    }
  }
}
