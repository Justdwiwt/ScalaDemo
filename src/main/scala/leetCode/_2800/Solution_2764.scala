package leetCode._2800

object Solution_2764 {
  def isPreorder(nodes: List[List[Int]]): Boolean = nodes.foldLeft((List(-1), true)) { case ((stack, isValid), node) =>
      if (!isValid) (stack, false)
      else {
        val child = node.head
        val parent = node(1)
        val updatedStack = stack.dropWhile(_ != parent)
        if (updatedStack.isEmpty) (stack, false)
        else (child :: updatedStack, true)
      }
    }
    ._2
}
