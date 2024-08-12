package leetCode._3300

object Solution_3244 {
  private class UnionFind(size: Int) {
    val fa: Array[Int] = Array.tabulate(size)(identity)

    def find(x: Int): Int = {
      if (fa(x) != x) fa(x) = find(fa(x))
      fa(x)
    }
  }

  def shortestDistanceAfterQueries(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    val uf = new UnionFind(n - 1)
    val res = Array.ofDim[Int](queries.length)
    var cnt = n - 1

    queries.indices.foreach(qi => {
      val l = queries(qi).head
      val r = queries(qi)(1) - 1
      val fr = uf.find(r)

      var i = uf.find(l)
      while (i < r) {
        uf.fa(i) = fr
        cnt -= 1
        i = uf.find(i + 1)
      }

      res(qi) = cnt
    })

    res
  }
}
