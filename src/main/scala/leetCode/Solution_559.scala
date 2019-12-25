package leetCode

object Solution_559 {

  private class Node(var _val: Int) {
    var value: Int = _val
    var children: Array[Node] = Array.empty
  }

  def maxDepth(root: Node): Int = root match {
    case null => 0
    case _ =>
      var mx = 0
      root.children.foreach(i => mx = mx.max(maxDepth(i)))
      mx
  }
}
