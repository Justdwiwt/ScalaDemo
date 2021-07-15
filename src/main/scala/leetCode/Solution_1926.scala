package leetCode

object Solution_1926 {
  def nearestExit(maze: Array[Array[Char]], entrance: Array[Int]): Int = {
    val m = maze.length
    val n = maze.head.length

    val diff = Array(1, 0, -1, 0, 1)

    val visited = collection.mutable.Set.empty[(Int, Int)]
    visited += ((entrance.head, entrance(1)))

    @scala.annotation.tailrec
    def bfs(l: List[(Int, Int)], c: Int): Int = if (l.isEmpty) -1 else {
      var list = List.empty[(Int, Int)]
      l.foreach(p => (0 to 3)
        .map({ i => val r = p._1 + diff(i); (i, r) })
        .withFilter({ case (_, r) => r >= 0 && r < m })
        .map({ case (i, r) => val c = p._2 + diff(i + 1); (i, r, c) })
        .withFilter({ case (_, _, c) => c >= 0 && c < n })
        .withFilter({ case (_, r, c) => maze(r)(c) == '.' && !visited.contains((r, c)) })
        .foreach({ case (_, r, c) => list = (r, c) :: list; visited += ((r, c)) })
      )

      if (list.exists(p => p._1 == 0 || p._1 == m - 1 || p._2 == 0 || p._2 == n - 1)) c else bfs(list, c + 1)
    }

    bfs(visited.toList, 1)
  }
}
