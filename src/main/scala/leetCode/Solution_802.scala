package leetCode

object Solution_802 {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    var res = List.empty[Int]
    val arr = Array.fill(graph.length)(0)
    graph.indices.foreach(i => if (dfs(graph, i, arr) == 2) res :+= i)

    def dfs(graph: Array[Array[Int]], idx: Int, arr: Array[Int]): Int = {
      if (arr(idx) == 1) return 3
      if (arr(idx) != 0) return arr(idx)
      arr(idx) = 1
      graph(idx).foreach(i => {
        if (dfs(graph, i, arr) == 3) {
          arr(i) = 3
          return 3
        }
      })
      arr(idx) = 2
      2
    }

    res
  }
}
