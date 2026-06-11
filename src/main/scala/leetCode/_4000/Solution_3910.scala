package leetCode._4000

object Solution_3910 {
  def evenSumSubgraphs(nums: Array[Int], edges: Array[Array[Int]]): Int = {
    val n = nums.length

    val g = Array.fill(n)(0)
    edges.foreach {
      case Array(x, y) =>
        g(x) |= 1 << y
        g(y) |= 1 << x
    }

    val ones = nums.zipWithIndex.foldLeft(0) { case (m, (x, i)) => m | (x << i) }

    val all = (1 << n) - 1

    def connected(sub: Int): Boolean = {
      @scala.annotation.tailrec
      def bfs(q: Int, vis: Int): Boolean =
        if (q == 0) vis == all
        else {
          val x = q & -q
          val to = g(Integer.numberOfTrailingZeros(x)) & ~vis
          bfs((q ^ x) | to, vis | to)
        }

      val start = sub & -sub
      bfs(start, (all ^ sub) | start)
    }

    (1 to all).count(sub => (Integer.bitCount(sub & ones) & 1) == 0 && connected(sub))
  }
}
