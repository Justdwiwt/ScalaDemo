package leetCode

object Solution_1034 {
  def colorBorder(grid: Array[Array[Int]], r0: Int, c0: Int, color: Int): Array[Array[Int]] = {
    bfs(grid, Seq((r0, c0)), Set.empty[(Int, Int)], Set.empty[(Int, Int)]).foreach(p => grid(p._1)(p._2) = color)
    grid
  }

  @scala.annotation.tailrec
  def bfs(grid: Array[Array[Int]], seq: Seq[(Int, Int)], vis: Set[(Int, Int)], res: Set[(Int, Int)]): Set[(Int, Int)] =
    if (seq.isEmpty) res
    else {
      val (newRes, newQ, newVis) = seq./:(res, Seq.empty[(Int, Int)], vis) { case ((nr, nq, nv), p) =>
        val neighbours = Seq((p._1 - 1, p._2), (p._1 + 1, p._2), (p._1, p._2 - 1), (p._1, p._2 + 1)).filter(n =>
          n._1 >= 0 &&
            n._1 < grid.length &&
            n._2 >= 0 &&
            n._2 < grid.head.length &&
            grid(n._1)(n._2) == grid(p._1)(p._2)
        )
        (if (neighbours.size == 4) nr else nr + p, neighbours.filterNot(vis.contains) ++ nq, nv + p)
      }

      bfs(grid, newQ, newVis, newRes)
    }
}
