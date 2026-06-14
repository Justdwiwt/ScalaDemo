package leetCode._4000

import scala.collection.Searching.search

object Solution_3911 {
  private def lowerBound(n: Int)(f: Int => Boolean): Int = {
    @scala.annotation.tailrec
    def dfs(l: Int, r: Int): Int =
      if (l >= r) l
      else {
        val m = l + (r - l) / 2
        if (f(m)) dfs(l, m)
        else dfs(m + 1, r)
      }

    dfs(0, n)
  }

  def kthRemainingInteger(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val evenPos = nums.indices.filter(i => (nums(i) & 1) == 0).toArray

    queries.map { q =>
      val Array(l, r, k) = q

      val li = evenPos.search(l).insertionPoint
      val ri = evenPos.search(r + 1).insertionPoint

      val j = lowerBound(ri - li)(x => nums(evenPos(li + x)) / 2 - 1 - x >= k)

      (j + k) * 2
    }
  }
}
