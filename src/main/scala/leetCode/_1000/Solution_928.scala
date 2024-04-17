package leetCode._1000

object Solution_928 {
  private var nodeId = 0
  private var size = 0

  def minMalwareSpread(graph: Array[Array[Int]], initial: Array[Int]): Int = {
    val n = graph.length
    val vis = Array.fill(n)(false)
    val isInitial = Array.fill(n)(false)
    var mn = Integer.MAX_VALUE

    initial.foreach(x => {
      isInitial(x) = true
      mn = mn.min(x)
    })

    val cnt = Array.fill(n)(0)
    graph.indices.foreach(i => if (vis(i) || isInitial(i)) () else {
      nodeId = -1
      size = 0
      dfs(i, graph, vis, isInitial)
      if (nodeId >= 0) cnt(nodeId) += size
    })

    var maxCnt = 0
    var minNodeId = -1
    graph.indices.foreach(i => if (cnt(i) > 0 && (cnt(i) > maxCnt || cnt(i) == maxCnt && i < minNodeId)) {
      maxCnt = cnt(i)
      minNodeId = i
    })
    if (minNodeId < 0) mn else minNodeId
  }

  private def dfs(x: Int, graph: Array[Array[Int]], vis: Array[Boolean], isInitial: Array[Boolean]): Unit = {
    vis(x) = true
    size += 1
    graph.indices.foreach(y =>
      if (graph(x)(y) == 0) ()
      else if (isInitial(y)) {
        if (nodeId != -2 && nodeId != y) nodeId = if (nodeId == -1) y else -2
      } else if (!vis(y)) dfs(y, graph, vis, isInitial))
  }
}
