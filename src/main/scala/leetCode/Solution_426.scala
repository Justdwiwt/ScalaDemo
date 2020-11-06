package leetCode

object Solution_426 {

  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = _
    var right: Node = _
  }

  def treeToDoublyList(root: Node): Node = {
    if (root == null) return root

    var pre: Node = null
    var head: Node = null

    def f(cur: Node): Unit = {
      if (cur == null) return
      f(cur.left)
      if (pre != null) pre.right = cur
      else head = cur
      cur.left = pre
      pre = cur
      f(cur.right)
    }

    f(root)
    head.left = pre
    pre.right = head
    head
  }
}
