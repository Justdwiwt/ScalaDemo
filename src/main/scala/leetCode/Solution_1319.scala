package leetCode

object Solution_1319 {

  class QuickUnionFind(_n: Int) {
    var cnt: Int = _n
    val parent: Array[Int] = Array.fill(_n)(0)
    val size: Array[Int] = Array.fill(_n)(0)
    (0 until _n).foreach(i => {
      parent(i) = i
      size(i) = 1
    })

    def union(_p: Int, _q: Int): Unit = {
      val p = find(_p)
      val q = find(_q)
      if (p == q) return
      if (size(p) > size(q)) {
        parent(q) = p
        size(p) += size(q)
      } else {
        parent(p) = q
        size(q) += size(p)
      }
      cnt -= 1
    }

    def find(_x: Int): Int = {
      var x = _x
      while (x != parent(x)) {
        parent(x) = parent(parent(x))
        x = parent(x)
      }
      x
    }

    def connected(_p: Int, _q: Int): Boolean = find(_p) == find(_q)

    def count(): Int = cnt
  }

  def makeConnected(n: Int, connections: Array[Array[Int]]): Int = {
    var cnt = 0
    val union = new QuickUnionFind(n)
    connections.foreach(i => {
      if (union.connected(i(0), i(1))) cnt += 1
      union.union(i(0), i(1))
    })
    val size = union.count() - 1
    if (cnt >= size) size else -1
  }

}
