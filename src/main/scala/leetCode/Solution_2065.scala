package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_2065 {
  def maximalPathQuality(values: Array[Int], edges: Array[Array[Int]], maxTime: Int): Int = {
    var res = 0
    val seen = Array.fill(values.length)(0)
    val graph = Array.fill(values.length)(ArrayBuffer.empty[(Int, Int)])
    edges
      .withFilter({ case Array(_, _, _) => true; case _ => false })
      .foreach({ case Array(from, to, len) =>
        graph(from) += ((to, len))
        graph(to) += ((from, len))
      })

    def dfs(cur: Int, qual: Int, left: Int): Unit = {
      if (left >= 0) {
        val nextQual = if (seen(cur) == 0) qual + values(cur) else qual
        if (cur == 0) res = res.max(nextQual)
        seen(cur) += 1
        graph(cur).foreach({ case (to, len) => dfs(to, nextQual, left - len) })
        seen(cur) -= 1
      }
    }

    dfs(0, 0, maxTime)
    res
  }
}
