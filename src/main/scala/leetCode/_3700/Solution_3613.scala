package leetCode._3700

object Solution_3613 {
  def minCost(n: Int, edges: Array[Array[Int]], k: Int): Int = {
    if (k == n) 0
    else {
      val sortedEdges = edges.sortBy(_(2))
      val uf = new UnionFind(n)

      sortedEdges.collectFirst {
        case edge if {
          val Array(x, y, _) = edge
          uf.merge(x, y)
          uf.cc == k
        } => edge(2)
      }.getOrElse(-1)
    }
  }

  private class UnionFind(n: Int) {
    private val parent = Array.tabulate(n)(identity)
    var cc: Int = n

    private def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    def merge(from: Int, to: Int): Unit = {
      val fx = find(from)
      val fy = find(to)
      if (fx != fy) {
        parent(fx) = fy
        cc -= 1
      }
    }
  }
}
