package leetCode._700

import leetCode.UnionFind

object Solution_684 {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
    val uf = new UnionFind[Int]
    edges.find { case Array(from, to) =>
      val (p1, p2) = (uf.find(from), uf.find(to))
      if (p1 == p2) true
      else {
        uf.union(p1, p2)
        false
      }
    }.get
  }
}
