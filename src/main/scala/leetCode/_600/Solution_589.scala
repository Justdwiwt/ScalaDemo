package leetCode._600

object Solution_589 {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def preorder(root: Node): List[Int] =
    if (root == null) Nil
    else root.value +: root.children.flatMap(preorder)
}
