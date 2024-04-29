package leetCode._1600

object Solution_1522 {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  var d: Int = 0

  private def maxDepth(node: Node, currDepth: Int): Int = {
    if (node.children.isEmpty) currDepth
    else {
      val (maxDepth1, maxDepth2) = node.children.foldLeft((currDepth, 0)) { case ((max1, max2), child) =>
        val depth = maxDepth(child, currDepth + 1)
        if (depth > max1) (depth, max1)
        else if (depth > max2) (max1, depth)
        else (max1, max2)
      }
      val distance = maxDepth1 + maxDepth2 - 2 * currDepth
      d = d.max(distance)
      maxDepth1
    }
  }

  def diameter(root: Node): Int = {
    d = 0
    maxDepth(root, 0)
    d
  }
}
