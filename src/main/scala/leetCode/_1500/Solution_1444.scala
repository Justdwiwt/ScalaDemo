package leetCode._1500

import scala.collection.mutable

object Solution_1444 {
  private val M = 1000000007L

  def ways(pizza: Array[String], k: Int): Int = {
    val (m, n) = (pizza.length, pizza.head.length)

    val dfsMem = mutable.Map.empty[(Int, Int, Int), Int]
    val postSumMem = mutable.Map.empty[(Int, Int), Int]

    def postSum(r: Int, c: Int): Int = postSumMem.getOrElseUpdate((r, c),
      if (r == m || c == n) 0
      else postSum(r + 1, c) + postSum(r, c + 1) - postSum(r + 1, c + 1) + (if (pizza(r)(c) == 'A') 1 else 0))

    def dfs(r: Int, c: Int, k: Int): Int = dfsMem.getOrElseUpdate((r, c, k),
      if (postSum(r, c) == 0) 0
      else if (k == 0) 1
      else {
        val horizontalWays = (r + 1 until m).foldLeft(0L)((ways, nr) =>
          if (postSum(r, c) - postSum(nr, c) == 0) ways else (ways + dfs(nr, c, k - 1)) % M)
        val verticalWays = (c + 1 until n).foldLeft(0L)((ways, nc) =>
          if (postSum(r, c) - postSum(r, nc) == 0) ways else (ways + dfs(r, nc, k - 1)) % M)
        ((horizontalWays + verticalWays) % M).toInt
      })

    dfs(0, 0, k - 1)
  }
}
