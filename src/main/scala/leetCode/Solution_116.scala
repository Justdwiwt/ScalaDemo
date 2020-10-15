package leetCode

object Solution_116 {

  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = _
    var right: Node = _
    var next: Node = _
  }

  def connect(root: Node): Node = root match {
    case null => null
    case _ =>
      if (root.left != null) {
        root.left.next = root.right
        if (root.next != null) {
          root.right.next = root.next.left
        }
      }
      connect(root.left)
      connect(root.right)
      root
  }
}
