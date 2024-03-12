package leetCode._200

import scala.collection.mutable.ListBuffer

object Solution_117 {

  class Node(var _value: Int) {
    var value: Int = _value
    val left: Node = null
    val right: Node = null
    var next: Node = _
  }

  def connect(root: Node): Node = {
    if (root != null) f(ListBuffer(root))
    root
  }

  @scala.annotation.tailrec
  def f(nodes: ListBuffer[Node]): Unit = {
    if (nodes.isEmpty) ()
    else {
      val nextLevel = level(nodes)
      if (nextLevel.nonEmpty) {
        nextLevel.reduce((l, r) => {
          l.next = r
          r
        })
        f(nextLevel)
      }
    }
  }

  def level(nodes: ListBuffer[Node]): ListBuffer[Node] = nodes./:(ListBuffer[Node]()) { (res, n) =>
    if (n.left != null) res += n.left
    if (n.right != null) res += n.right
    res
  }
}
