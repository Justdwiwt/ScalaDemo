package leetCode._2000

import leetCode.UnionFind

object Solution_1971 {
  def validPath(n: Int, edges: Array[Array[Int]], start: Int, end: Int): Boolean = {
    val uf = new UnionFind[Int]
    edges.foreach { case Array(n1, n2) => uf.union(n1, n2) }
    uf.find(start) == uf.find(end)
  }
}
