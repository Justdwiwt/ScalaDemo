package leetCode

import scala.collection.mutable

object Solution_117 {

  class Node(var _value: Int) {
    var value: Int = _value
    val left: Node = null
    val right: Node = null
    var next: Node = _
  }

  def connect(root: Node): Node = root match {
    case null => root
    case _ =>
      val q = new mutable.Queue[Node]()
      q.enqueue(root)
      while (q.nonEmpty) {
        val size = q.size
        q.indices.foreach(i => {
          val node = q.head
          q.dequeue()
          if (i < size - 1) node.next = q.head
          if (node.left != null) q.enqueue(node.left)
          if (node.right != null) q.enqueue(node.right)
        })
      }
      root
  }
}
