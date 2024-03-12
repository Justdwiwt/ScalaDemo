package leetCode._2500

object Solution_2492 {
  def minScore(n: Int, roads: Array[Array[Int]]): Int = {
    def find(p: Vector[Int], x: Int): (Vector[Int], Int) =
      if (p(x) == x) (p, x)
      else {
        val (px, rx) = find(p, p(x))
        (px.updated(x, rx), rx)
      }

    def union(p: Vector[Int], a: Array[Int]): Vector[Int] = {
      val (px, rx) = find(p, a(0))
      val (py, ry) = find(px, a(1))
      py.updated(rx, ry)
    }

    val parents = roads./:((0 to n).toVector)(union)
    val roots = (1 to n).scanLeft(parents, 0) { case ((p, _), x) => find(p, x) }.map(_._2)

    roads.withFilter(x => roots(x.head) == roots(1) || roots(x(1)) == roots(1)).map(_(2)).min
  }
}
