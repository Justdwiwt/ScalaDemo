package leetCode

object Solution_2846 {
  def minOperationsQueries(n: Int, edges: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val M = 15
    val N = 27
    val g = Array.fill(N)(Array.empty[(Int, Int)])
    edges.foreach(e => {
      g(e(0)) :+= (e(1), e(2))
      g(e(1)) :+= (e.head, e(2))
    })
    val fa = Array.fill(M, N)(0)
    val w = Array.fill(N, N)(0)
    val d = Array.fill(N)(0)
    dfs(0, 0, 0, g, fa, w, d)
    (1 until M).foreach(i => (0 until N).foreach(j => fa(i)(j) = fa(i - 1)(fa(i - 1)(j))))
    val res = Array.fill(queries.length)(0)
    queries.indices.foreach(i => {
      val x = queries(i).head
      val y = queries(i)(1)
      val l = lca(x, y, fa, d)
      val len = d(x) + d(y) - 2 * d(l)
      var maxZ = 0
      (1 until N).foreach(z => {
        val numZ = w(x)(z) + w(y)(z) - w(l)(z) * 2
        maxZ = maxZ.max(numZ)
      })
      res(i) = len - maxZ
    })
    res
  }

  private def dfs(x: Int, f: Int, dep: Int, g: Array[Array[(Int, Int)]], fa: Array[Array[Int]], w: Array[Array[Int]], d: Array[Int]): Unit = {
    fa.head(x) = f
    d(x) = dep
    g(x).withFilter(x => x._1 != f).foreach(p => {
      val c = p._1
      val weight = p._2
      w(c).indices.foreach(j => w(c)(j) = w(x)(j))
      w(c)(weight) += 1
      dfs(c, x, dep + 1, g, fa, w, d)
    })
  }

  private def lca(_x: Int, _y: Int, fa: Array[Array[Int]], d: Array[Int]): Int = {
    val m = fa.length
    var x = _x
    var y = _y
    if (d(x) > d(y)) {
      val t = x
      x = y
      y = t
    }
    var p = 0
    while ((1 << p) <= d(y) - d(x)) {
      if (((1 << p) & d(y) - d(x)) != 0) y = fa(p)(y)
      p += 1
    }
    var q = m - 1
    while (q >= 0) {
      if (fa(q)(x) != fa(q)(y)) {
        x = fa(q)(x)
        y = fa(q)(y)
      }
      q -= 1
    }
    if (x == y) x else fa.head(x)
  }
}
