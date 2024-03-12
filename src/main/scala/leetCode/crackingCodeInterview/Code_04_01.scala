package leetCode.crackingCodeInterview

object Code_04_01 {
  def findWhetherExistsPath(n: Int, graph: Array[Array[Int]], start: Int, target: Int): Boolean = {
    if (start == target) return true
    graph.foreach(e => if (e(1) == target) return findWhetherExistsPath(n, graph, start, e.head))
    false
  }
}
