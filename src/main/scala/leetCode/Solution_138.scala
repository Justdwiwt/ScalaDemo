package leetCode

import scala.collection.mutable

object Solution_138 {

  class Node(var _value: Int) {
    var value: Int = _value
    var next: Node = _
    var random: Node = _
  }

  def copyRandomList(head: Node): Node = {
    if (head == null) return null
    f(head, mutable.Map.empty[Node, Node])
  }


  def f(node: Node, visited: mutable.Map[Node, Node]): Node = visited.get(node) match {
    case Some(x) => x
    case None =>
      val newNode = new Node(node.value)
      visited(node) = newNode
      (Option(node.next), Option(node.random)) match {
        case (Some(x), None) => newNode.next = f(x, visited)
        case (None, Some(x)) => newNode.random = f(x, visited)
        case (Some(x), Some(y)) =>
          newNode.next = f(x, visited)
          newNode.random = f(y, visited)
        case (None, None) => ()
      }
      newNode
  }
}
