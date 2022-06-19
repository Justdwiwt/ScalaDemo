package leetCode

object Solution_2304 {
  def minPathCost(grid: Array[Array[Int]], moveCost: Array[Array[Int]]): Int = {
    val cost = Array.fill(grid.length)(Array.fill(grid.head.length)(Int.MaxValue))
    grid.head.indices.foreach(i => cost.head(i) = grid.head(i))
    grid.indices.dropRight(1).foreach(r =>
      grid.head.indices.foreach(c0 =>
        grid.head.indices.foreach(c1 =>
          cost(r + 1)(c1) = cost(r + 1)(c1).min(grid(r + 1)(c1) + cost(r)(c0) + moveCost(grid(r)(c0))(c1)))))
    cost.last.min
  }
}
