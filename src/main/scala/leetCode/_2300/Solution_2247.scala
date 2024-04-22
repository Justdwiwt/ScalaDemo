package leetCode._2300

import scala.collection.mutable

object Solution_2247 {
  def maximumCost(n: Int, highways: Array[Array[Int]], k: Int): Int = {
    if (k >= n) return -1

    val path = Array.fill(n)(mutable.ListBuffer.empty[Int])
    val fee = Array.ofDim[Int](n, n)

    highways.foreach(highway => {
      val a = highway.head
      val b = highway(1)
      val c = highway(2)
      path(a) += b
      path(b) += a
      fee(a)(b) = c
      fee(b)(a) = c
    })

    var res = -1

    def dfs(i: Int, visited: Array[Boolean], cost: Int, cur: Int): Unit = {
      if (cur == 0) {
        if (cost > res) res = cost
        return
      }
      visited(i) = true
      path(i).foreach(j => if (!visited(j)) dfs(j, visited.clone(), cost + fee(i)(j), cur - 1))
    }

    (0 until n).foreach(dfs(_, Array.fill(n)(false), 0, k))

    res
  }
}
