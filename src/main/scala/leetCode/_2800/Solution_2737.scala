package leetCode._2800

object Solution_2737 {
  private val INF = Int.MaxValue / 2

  def minimumDistance(n: Int, edges: List[List[Int]], s: Int, marked: Array[Int]): Int = {
    val distances = f(n, edges, s)
    val minDistance = marked.map(distances).foldLeft(INF)(Math.min)
    if (minDistance != INF) minDistance else -1
  }

  private def f(n: Int, edges: List[List[Int]], source: Int): Array[Int] = {
    val distances = Array.fill(n)(INF)
    distances(source) = 0

    def relaxEdges(dist: Array[Int], edge: List[Int]): Array[Int] = {
      val u = edge.head
      val v = edge(1)
      val w = edge(2)
      if (dist(u) != INF && dist(v) > dist(u) + w) dist.updated(v, dist(u) + w)
      else dist
    }

    (1 until n).foldLeft(distances)((dist, _) => edges.foldLeft(dist)(relaxEdges))
  }
}
