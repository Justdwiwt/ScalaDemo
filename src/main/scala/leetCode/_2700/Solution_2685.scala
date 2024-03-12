package leetCode._2700

object Solution_2685 {
  private case class UnionFind(n: Int) {
    val p: Array[Int] = Array.range(0, n)

    private def find(a: Int): Int = {
      if (p(a) == a) return a
      p(a) = find(p(a))
      p(a)
    }

    def union(a: Int, b: Int): Boolean = {
      val rootA = find(a)
      val rootB = find(b)
      if (rootA == rootB) return false
      if (rootA < rootB) p(rootB) = rootA
      else p(rootA) = rootB
      true
    }
  }

  def countCompleteComponents(n: Int, edges: Array[Array[Int]]): Int = {
    val uf = UnionFind(n)
    edges.foreach(e => uf.union(e.head, e(1)))
    edges.foreach(e => uf.union(e.head, e(1)))

    val m1 = uf.p.groupBy(identity).mapValues(_.length).mapValues(n => n * (n - 1) / 2)
    val ms = (0 until n).zip(uf.p).toMap
    val m2 = edges.map(n => n(0)).map(ms.getOrElse(_, -1)).groupBy(identity).mapValues(_.length)

    (m1.map(n => n._1 + "#" + n._2) ++ m2.map(n => n._1 + "#" + n._2)).groupBy(identity).mapValues(_.size).count(_._2 == 2) + m1.values.count(_ == 0)
  }
}
