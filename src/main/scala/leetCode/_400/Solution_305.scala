package leetCode._400

import scala.collection.mutable.ListBuffer

object Solution_305 {
  private class UF(val n: Int) {
    private var count: Int = 0
    private val parent: Array[Int] = Array.tabulate(n)(identity)
    private val size: Array[Int] = Array.fill(n)(1)

    def union(p: Int, q: Int): Unit = {
      val rootP = find(p)
      val rootQ = find(q)
      if (rootP == rootQ) return

      if (size(rootP) > size(rootQ)) {
        parent(rootQ) = rootP
        size(rootP) += size(rootQ)
      } else {
        parent(rootP) = rootQ
        size(rootQ) += size(rootP)
      }
      count -= 1
    }

    def connected(p: Int, q: Int): Boolean = {
      val rootP = find(p)
      val rootQ = find(q)
      rootP == rootQ
    }

    private def find(x: Int): Int = {
      var tempX = x
      while (parent(tempX) != tempX) {
        parent(tempX) = parent(parent(tempX))
        tempX = parent(tempX)
      }
      tempX
    }

    def plusCount(): Unit =
      count += 1

    def minusCount(): Unit =
      count -= 1

    def getCount: Int =
      count
  }

  def numIslands2(m: Int, n: Int, positions: Array[Array[Int]]): List[Int] = {
    if (m == 0 || positions.length == 0) return Nil

    val uf = new UF(m * n)
    val grid = Array.ofDim[Int](m, n)
    val res = ListBuffer.empty[Int]

    def isValid(r: Int, c: Int): Boolean =
      0 <= r && r < m && 0 <= c && c < n

    positions.foreach(position => {
      val x = position.head
      val y = position(1)

      if (isValid(x, y) && grid(x)(y) == -1)
        uf.minusCount()

      grid(x)(y) = -1
      uf.plusCount()

      if (isValid(x, y + 1) && grid(x)(y + 1) == -1)
        uf.union(x * n + y, x * n + y + 1)
      if (isValid(x, y - 1) && grid(x)(y - 1) == -1)
        uf.union(x * n + y, x * n + y - 1)
      if (isValid(x + 1, y) && grid(x + 1)(y) == -1)
        uf.union(x * n + y, (x + 1) * n + y)
      if (isValid(x - 1, y) && grid(x - 1)(y) == -1)
        uf.union(x * n + y, (x - 1) * n + y)

      res += uf.getCount
    })
    res.toList
  }

}
