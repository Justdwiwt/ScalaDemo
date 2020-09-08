package leetCode

object Solution_685 {

  class UF(n: Int) {
    val (sz, par) = (new Array[Int](n), new Array[Int](n))
    var ops: Int = n
    (0 until n).foreach(i => {
      par(i) = i
      sz(i) = 1
    })

    def find(x: Int): Int = {
      if (par(x) == x) x
      else {
        par(x) = find(par(x))
        par(x)
      }
    }

    def getCnt: Int = ops

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) par(py) = px
      ops = ops - 1
    }
  }

  def findRedundantDirectedConnection(edges: Array[Array[Int]]): Array[Int] = {
    var cnt = -1
    val arr = new Array[Int](edges.length)
    edges.indices.foreach(i => {
      val v = edges(i)(1) - 1
      arr(v) = arr(v) + 1
      if (arr(v) == 2) cnt = v
    })
    var res = new Array[Int](2)
    if (cnt == -1) return findRedundantConnection(edges, -1)
    edges.indices.foreach(i => if (edges(i)(1) == cnt + 1) if (findRedundantConnection(edges, i) == null) res = edges(i))
    res
  }

  def findRedundantConnection(edges: Array[Array[Int]], skip: Int): Array[Int] = {
    val uf = new UF(edges.length)
    edges.indices.withFilter(i => i != skip).foreach(i => {
      val x = uf.find(edges(i)(0) - 1)
      val y = uf.find(edges(i)(1) - 1)
      if (x == y) return edges(i)
      else uf.union(x, y)
    })
    null
  }

}
