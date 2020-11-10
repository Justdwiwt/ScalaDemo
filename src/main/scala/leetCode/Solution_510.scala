package leetCode

object Solution_510 {

  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = _
    var right: Node = _
    var parent: Node = _
  }

  def inorderSuccessor(node: Node): Node = {
    var root = node
    if (root.right != null) {
      root = root.right
      while (root.left != null) root = root.left
      root
    } else {
      while (root.parent != null && root.parent.value < root.value) root = root.parent
      root.parent
    }
  }
}
