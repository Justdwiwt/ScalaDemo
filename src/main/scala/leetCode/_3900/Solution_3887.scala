package leetCode._3900

object Solution_3887 {
  final class UnionFind(n: Int) {
    private val fa = Array.tabulate(n)(identity)
    private val dis = Array.fill(n)(0)

    def find(x: Int): Int =
      if (fa(x) == x) x
      else {
        val parent = fa(x)
        val root = find(parent)
        dis(x) ^= dis(parent)
        fa(x) = root
        root
      }

    def merge(x: Int, y: Int, w: Int): Boolean = {
      val fx = find(x)
      val fy = find(y)

      if (fx == fy)
        (dis(x) ^ dis(y)) == w
      else {
        dis(fx) = w ^ dis(x) ^ dis(y)
        fa(fx) = fy
        true
      }
    }
  }

  def numberOfEdgesAdded(n: Int, edges: Array[Array[Int]]): Int = {
    val uf = new UnionFind(n)

    edges.count {
      case Array(x, y, w) =>
        uf.merge(x, y, w)
    }
  }
}
