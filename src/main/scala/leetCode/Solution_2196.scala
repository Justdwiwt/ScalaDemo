package leetCode

object Solution_2196 {
  def createBinaryTree(descriptions: Array[Array[Int]]): TreeNode = {
    val (nodes, children) = descriptions./:(Map.empty[Int, TreeNode], Set.empty[Int]) {
      case ((nodes, children), Array(parent, child, isLeft)) =>
        val newNodes = nodes
          .updated(parent, nodes.getOrElse(parent, new TreeNode(parent)))
          .updated(child, nodes.getOrElse(child, new TreeNode(child)))

        if (isLeft == 1) newNodes(parent).left = newNodes(child)
        else newNodes(parent).right = newNodes(child)

        (newNodes, children + child)
    }
    nodes(nodes.keySet.diff(children).head)
  }
}
