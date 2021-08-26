package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_1857 {
  val VISIT_STATE = 26
  val VISITING = 1
  val VISITED = 2

  def largestPathValue(colors: String, edges: Array[Array[Int]]): Int = {
    val graph = Array.fill(colors.length)(ArrayBuffer.empty[Int])
    edges
      .withFilter({ case Array(_, _) => true; case _ => false })
      .foreach({ case Array(u, v) => graph(u).append(v) })
    val bestPaths = Array.ofDim[Int](colors.length, VISIT_STATE + 1)

    def dfs(node: Int): Boolean =
      if (bestPaths(node)(VISIT_STATE) == VISITING) true
      else if (bestPaths(node)(VISIT_STATE) == VISITED) false
      else {
        bestPaths(node)(VISIT_STATE) = VISITING
        var cycle = false
        graph(node).foreach(next =>
          if (!cycle) {
            cycle = dfs(next)
            (0 until VISIT_STATE).foreach(c => bestPaths(node)(c) = bestPaths(node)(c).max(bestPaths(next)(c)))
          })
        bestPaths(node)(colors(node) - 'a') += 1
        bestPaths(node)(VISIT_STATE) = VISITED
        cycle
      }

    var flag = false
    var idx = 0
    var best = 0
    while (!flag && idx < colors.length) {
      flag = dfs(idx)
      (0 until VISIT_STATE).foreach(c => best = best.max(bestPaths(idx)(c)))
      idx += 1
    }
    if (flag) -1 else best
  }
}
