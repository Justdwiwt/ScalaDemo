package leetCode._2400

object Solution_2360 {
  def longestCycle(edges: Array[Int]): Int = edges
    .indices
    ./:(Set.empty[Int], -1) { case ((globalVisited, longestCycle), node) =>
      def f(node: Int): (Set[Int], Int) = {
        val (last, path) = Iterator
          .iterate((node, Map.empty[Int, Int])) { case (cur, path) => (edges(cur), path + (cur -> path.size)) }
          .dropWhile { case (cur, path) => cur != -1 && !path.contains(cur) && !globalVisited.contains(cur) }
          .next()
        (path.keySet, path.get(last).map(path.size - _).getOrElse(-1))
      }

      val (localVisited, cycleLength) = f(node)
      (globalVisited ++ localVisited, longestCycle.max(cycleLength))
    }
    ._2
}
