package leetCode._1500

object Solution_1490 {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def cloneTree(root: Node): Node = {
    if (root != null) {
      val t = new Node(root.value)
      root.children.foreach(t.children :+= cloneTree(_))
      t
    } else null
  }
}
