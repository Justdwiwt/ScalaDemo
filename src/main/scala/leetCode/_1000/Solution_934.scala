package leetCode._1000

object Solution_934 {
  def shortestBridge(grid: Array[Array[Int]]): Int = {
    type Point = (Int, Int)

    def isLand(p: Point): Boolean =
      grid(p._1)(p._2) == 1

    def around(p: Point): Set[Point] = {
      val (i, j) = p
      Set((i - 1, j), (i, j - 1), (i + 1, j), (i, j + 1)).filter { case (i, j) => grid.indices.contains(i) && grid.indices.contains(j) }
    }

    def explore(start: Set[Point])(allowed: Point => Boolean)(done: Set[Point] => Boolean): (Set[Point], Int) = Stream
      .iterate((start, start, 0)) { case (from, visited, d) =>
        val nextFrom = from.flatMap(around).filter(allowed)
        (nextFrom -- visited, nextFrom ++ visited, d + 1)
      }
      .collectFirst { case (from, visited, d) if done(from) => (visited, d) }
      .get

    val i = grid.indexWhere(_.contains(1))
    val j = grid(i).indexOf(1)
    val firstIsland = explore(Set((i, j)))(isLand)(_.isEmpty)._1
    val aroundIsland = firstIsland.flatMap(around).filterNot(isLand)
    explore(aroundIsland)(!firstIsland(_))(_.exists(isLand))._2
  }
}
