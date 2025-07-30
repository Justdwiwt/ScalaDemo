package leetCode._3700

object Solution_3608 {
  def minTime(n: Int, edges: Array[Array[Int]], k: Int): Int = {
    val sorted = edges.sortBy(-_(2))
    val uf = new UnionFind(n)

    sorted.collectFirst {
      case Array(x, y, t) if {
        uf.merge(x, y)
        uf.cc < k
      } => t
    }.getOrElse(0)
  }

  private class UnionFind(n: Int) {
    private val parent = (0 until n).toArray
    var cc: Int = n

    private def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    def merge(a: Int, b: Int): Unit = {
      val fa = find(a)
      val fb = find(b)
      if (fa != fb) {
        parent(fa) = fb
        cc -= 1
      }
    }
  }
}
