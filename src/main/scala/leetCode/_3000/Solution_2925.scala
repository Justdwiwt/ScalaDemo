package leetCode._3000

import scala.collection.mutable.ArrayBuffer

object Solution_2925 {
  def maximumScoreAfterOperations(edges: Array[Array[Int]], values: Array[Int]): Long = {
    val arr = Array.fill(values.length)(ArrayBuffer[Int]())
    arr(0) += -1
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      arr(x) += y
      arr(y) += x
    })

    var res = 0L
    values.foreach(v => res += v)
    res - dfs(0, -1, arr, values)
  }

  private def dfs(x: Int, fa: Int, g: Array[ArrayBuffer[Int]], values: Array[Int]): Long = {
    if (g(x).size == 1) return values(x)
    var loss = 0L
    g(x).foreach(y => if (y != fa) loss += dfs(y, x, g, values))
    loss.min(values(x))
  }
}
