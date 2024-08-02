package leetCode._3300

object Solution_3235 {
  private class UnionFind(size: Int) {
    private val fa = Array.tabulate(size)(identity)

    def find(x: Int): Int = {
      if (fa(x) != x) fa(x) = find(fa(x))
      fa(x)
    }

    def merge(x: Int, y: Int): Unit =
      fa(find(x)) = find(y)
  }

  def canReachCorner(x: Int, y: Int, circles: Array[Array[Int]]): Boolean = {
    val n = circles.length
    val uf = new UnionFind(n + 2)

    def mergeCircles(i: Int): Unit = {
      val c = circles(i)
      val (ox, oy, r) = (c.head, c(1), c(2))

      if (ox <= r || oy + r >= y) uf.merge(i, n)
      if (oy <= r || ox + r >= x) uf.merge(i, n + 1)

      (0 until i).foreach(j => {
        val q = circles(j)
        if ((ox - q.head).toLong * (ox - q.head) + (oy - q(1)).toLong * (oy - q(1)) <= (r + q(2)).toLong * (r + q(2)))
          uf.merge(i, j)
      })
    }

    circles.indices.foldLeft(true)((res, i) =>
      if (res) {
        mergeCircles(i)
        uf.find(n) != uf.find(n + 1)
      } else false
    )
  }
}
