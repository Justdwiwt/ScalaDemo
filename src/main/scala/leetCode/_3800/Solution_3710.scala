package leetCode._3800

object Solution_3710 {
  final class UnionFind(n: Int) {
    private val fa = Array.tabulate(n)(identity)
    private val dis = Array.fill(n)(0)

    def find(x: Int): Int =
      if (fa(x) == x) x
      else {
        val rt = find(fa(x))
        dis(x) ^= dis(fa(x))
        fa(x) = rt
        rt
      }

    def merge(a: Int, b: Int): Boolean = {
      val x = find(a)
      val y = find(b)
      if (x == y) dis(a) != dis(b)
      else {
        dis(x) = dis(a) ^ dis(b) ^ 1
        fa(x) = y
        true
      }
    }
  }

  def maxPartitionFactor(points: Array[Array[Int]]): Int = {

    val edges = points
      .indices
      .flatMap(i => (0 until i)
        .map { j => val v$1@Array(x1, y1) = points(i); (j, v$1) }
        .map { case (j, Array(x1, y1)) => val v$2@Array(x2, y2) = points(j); (j, Array(x1, y1), v$2) }
        .map { case (j, Array(x1, y1), Array(x2, y2)) => (math.abs(x1 - x2) + math.abs(y1 - y2), i, j) }
      )
      .sortBy(_._1)

    val uf = new UnionFind(points.length)

    edges.collectFirst {
      case (d, x, y) if !uf.merge(x, y) => d
    }.getOrElse(0)
  }
}
