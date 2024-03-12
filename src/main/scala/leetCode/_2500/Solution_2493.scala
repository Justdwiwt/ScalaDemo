package leetCode._2500

object Solution_2493 {
  def magnificentSets(n: Int, edges: Array[Array[Int]]): Int = {
    @scala.annotation.tailrec
    def find(p: Map[Int, Int])(x: Int): Int =
      if (p(x) == x) x
      else find(p)(p(x))

    def union(p: Map[Int, Int], a: Array[Int]): Map[Int, Int] = {
      val Array(rx, ry) = a.map(find(p))
      p + (rx -> ry)
    }

    val parents = edges./:((1 to n).zip(1 to n).toMap)(union)
    val groups = (1 to n).groupBy(find(parents)).values

    val adj = edges./:(Map[Int, Set[Int]]().withDefaultValue(Set[Int]())) {
      case (m, Array(x, y)) => m + (x -> (m(x) + y)) + (y -> (m(y) + x))
    }

    @scala.annotation.tailrec
    def bfs(layer: Set[Int], visited: Set[Int], groups: Int): Int =
      if (layer.isEmpty) groups
      else {
        val nexts = layer.flatMap(adj(_).filter(!visited.contains(_)))
        if ((nexts & layer).nonEmpty) -1
        else bfs(nexts, visited ++ layer, groups + 1)
      }

    val res = groups.map(_.map(y => bfs(Set(y), Set[Int](), 0)).max).toSeq

    if (res.contains(-1)) -1
    else res.sum
  }
}
