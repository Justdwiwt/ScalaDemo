package leetCode._1600

object Solution_1516 {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def moveSubTree(root: Node, p: Node, q: Node): Node = {
    val dummy = new Node(0)
    dummy.children :+= root
    var pParent: Node = null
    var qParent: Node = null
    var flag = false

    def dfs(node: Node, parent: Node, target: Boolean): Unit = {
      var t = target
      if (node == p) {
        pParent = parent
        t = true
      }
      if (node == q) {
        if (t) flag = true
        qParent = parent
      }

      node.children.foreach(dfs(_, node, t))
    }

    dfs(root, dummy, target = false)

    if (pParent == q) return root

    if (flag) {
      qParent.children = qParent.children.filterNot(_ == q)
      val idx = pParent.children.indexOf(p)
      val updatedChildren = pParent.children.updated(idx, q)
      pParent.children = updatedChildren
      q.children :+= p
    } else {
      pParent.children = pParent.children.filterNot(_ == p)
      q.children :+= p
    }

    dummy.children.head
  }
}
