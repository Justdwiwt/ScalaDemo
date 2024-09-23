package leetCode._3300

object Solution_3294 {
  class Node {
    var value = 0
    var prev: Node = _
    var next: Node = _
  }

  def toArray(node: Node): Array[Int] = {
    @annotation.tailrec
    def findHead(n: Node): Node = {
      if (n.prev == null) n
      else findHead(n.prev)
    }

    @annotation.tailrec
    def findTail(n: Node): Node = {
      if (n.next == null) n
      else findTail(n.next)
    }

    @scala.annotation.tailrec
    def lengthFromHead(n: Node, length: Int = 0): Int = {
      if (n == null) length
      else lengthFromHead(n.next, length + 1)
    }

    @scala.annotation.tailrec
    def buildArray(n: Node, array: Array[Int], index: Int = 0): Array[Int] = {
      if (n == null) array
      else {
        array(index) = n.value
        buildArray(n.next, array, index + 1)
      }
    }

    val head = findHead(node)
    val length = lengthFromHead(head)
    val array = new Array[Int](length)
    buildArray(head, array)
  }
}
