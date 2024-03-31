package leetCode._1000

import leetCode.UnionFind

object Solution_947 {
  def removeStones(stones: Array[Array[Int]]): Int = {
    val uf = new UnionFind[Int]
    stones.foreach { case Array(x, y) => uf.union(x, y + 10000) }
    stones.length - uf.nodes().map(uf.find).size
  }
}
