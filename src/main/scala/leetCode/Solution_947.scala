package leetCode

import leetCode.Solution_1319.QuickUnionFind

object Solution_947 {
  def removeStones(stones: Array[Array[Int]]): Int = {
    val union = new QuickUnionFind(stones.length)
    stones.indices.foreach(i => (i + 1 until stones.length).foreach(j => if (stones(i)(0) == stones(j)(0) || stones(i)(1) == stones(j)(1)) union.union(i, j)))
    stones.length - union.count()
  }
}
