package leetCode._3200

object Solution_3108 {
  def minimumCost(n: Int, edges: Array[Array[Int]], query: Array[Array[Int]]): Array[Int] = {
    val fa = Array.range(0, n)
    val and = Array.fill(n)(-1)
    val res = new Array[Int](query.length)

    edges.foreach(e => {
      val x = find(e.head, fa)
      val y = find(e(1), fa)
      and(y) &= e(2)
      if (x != y) {
        and(y) &= and(x)
        fa(x) = y
      }
    })

    query.indices.foreach(i => {
      val s = query(i).head
      val t = query(i)(1)
      res(i) = if (s == t) 0 else if (find(s, fa) != find(t, fa)) -1 else and(find(s, fa))
    })
    res
  }

  private def find(x: Int, fa: Array[Int]): Int = {
    @scala.annotation.tailrec
    def loop(root: Int): Int =
      if (root != fa(root)) loop(fa(root))
      else root

    val root = loop(x)

    @scala.annotation.tailrec
    def compress(i: Int): Unit = if (i != root) {
      val next = fa(i)
      fa(i) = root
      compress(next)
    }

    compress(x)
    root
  }
}
