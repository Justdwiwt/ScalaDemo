package leetCode._800

object Solution_742 {
  class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)

  def findClosestLeaf(root: TreeNode, k: Int): Int = {
    val graph = buildGraph(root, null, Map.empty[TreeNode, List[TreeNode]])
    val queue = collection.mutable.Queue.empty[TreeNode]
    val seen = collection.mutable.Set.empty[TreeNode]

    graph
      .keys
      .withFilter(node => node != null && node.value == k)
      .foreach(node => {
        queue += node
        seen += node
      })

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      if (node != null) {
        if (graph(node).size <= 1) return node.value
        graph(node).foreach(nei => if (!seen.contains(nei)) {
          seen += nei
          queue += nei
        })
      }
    }
    throw new RuntimeException("No closest leaf found")
  }

  private def buildGraph(node: TreeNode, parent: TreeNode, graph: Map[TreeNode, List[TreeNode]]): Map[TreeNode, List[TreeNode]] =
    if (node == null) graph
    else {
      val updatedGraph = graph + (node -> (graph.getOrElse(node, Nil) :+ parent)) + (parent -> (graph.getOrElse(parent, Nil) :+ node))
      buildGraph(node.left, node, buildGraph(node.right, node, updatedGraph))
    }
}
