package leetCode._600

object Solution_559 {

  private class Node(var _val: Int) {
    var value: Int = _val
    var children: Array[Node] = Array.empty
  }

  def maxDepth(root: Node): Int = {
    if (root == null) 0
    else if (root.children == null || root.children.isEmpty) 1
    else root.children./:(1)((acc, n) => acc.max(1 + maxDepth(n)))
  }
}
