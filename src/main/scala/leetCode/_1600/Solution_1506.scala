package leetCode._1600

object Solution_1506 {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = Nil
  }

  def findRoot(tree: List[Node]): Node = {
    val xorSum = tree.foldLeft(0)((acc, node) => acc ^ node.value ^ node.children.map(_.value).foldLeft(0)(_ ^ _))
    tree.find(_.value == xorSum).orNull
  }
}
