package leetCode

import scala.util.control.Breaks._

object Solution_913 {
  def catMouseGame(graph: Array[Array[Int]]): Int = {
    val dp = Array.fill(2 * graph.length, graph.length, graph.length)(-1)
    func(graph, 0, 1, 2, dp)
  }

  def func(graph: Array[Array[Int]], t: Int, x: Int, y: Int, dp: Array[Array[Array[Int]]]): Int = {
    if (t == graph.length * 2) return 0
    if (x == y) return 2
    if (x == 0) return 1
    if (dp(t)(x)(y) != -1) return dp(t)(x)(y)
    val flag = t % 2 == 0
    if (flag) {
      var catWin = true
      graph(x).indices.foreach(i => {
        val next = func(graph, t + 1, graph(x)(i), y, dp)
        if (next == 1) dp(t)(x)(y) = 1
        else if (next != 2) catWin = false
      })
      if (catWin) 2 else 0
    } else {
      var mouseWin = true
      graph(y).indices.foreach(i => {
        breakable {
          if (graph(y)(i) == 0) break
        }
        val next = func(graph, t + 1, x, graph(y)(i), dp)
        if (next == 2) dp(t)(x)(y) = 2
        else if (next != 1) mouseWin = false
      })
      if (mouseWin) 1 else 0
    }
  }
}
