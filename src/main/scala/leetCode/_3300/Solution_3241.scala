package leetCode._3300

import scala.collection.mutable.ListBuffer

object Solution_3241 {
  def timeTaken(edges: Array[Array[Int]]): Array[Int] = {
    val n = edges.length + 1
    val g = Array.fill(n)(new ListBuffer[Int]())
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x) += y
      g(y) += x
    })

    val nodes = Array.ofDim[Int](g.length, 3)
    dfs(0, -1, g, nodes)

    val res = Array.ofDim[Int](g.length)
    reRoot(0, -1, 0, g, nodes, res)
    res
  }

  private def dfs(x: Int, fa: Int, g: Array[ListBuffer[Int]], nodes: Array[Array[Int]]): Int = {
    var maxD = 0
    var maxD2 = 0
    var my = 0

    g(x).foreach(y => if (y != fa) {
      val depth = dfs(y, x, g, nodes) + 2 - y % 2
      if (depth > maxD) {
        maxD2 = maxD
        maxD = depth
        my = y
      } else if (depth > maxD2) maxD2 = depth
    })

    nodes(x)(0) = maxD
    nodes(x)(1) = maxD2
    nodes(x)(2) = my
    maxD
  }

  private def reRoot(x: Int, fa: Int, fromUp: Int, g: Array[ListBuffer[Int]], nodes: Array[Array[Int]], res: Array[Int]): Unit = {
    val maxD = nodes(x)(0)
    val maxD2 = nodes(x)(1)
    val my = nodes(x)(2)
    res(x) = fromUp.max(maxD)
    g(x).foreach(y => if (y != fa) reRoot(y, x, fromUp.max(if (y == my) maxD2 else maxD) + 2 - x % 2, g, nodes, res))
  }
}
