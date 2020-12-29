package leetCode

object Solution_590 {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def postorder(root: Node): List[Int] = {
    if (root == null) return Nil
    root.children.flatMap(postorder) :+ root.value
  }
}
