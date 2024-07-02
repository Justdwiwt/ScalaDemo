package leetCode._800

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_716 {

  class MaxStack {

    class Node(val value: Int) {
      var prev: Node = _
      var next: Node = _
    }

    private class DoubleLinkedList {
      private val head: Node = new Node(0)
      val tail: Node = new Node(0)
      head.next = tail
      tail.prev = head

      def addTop(node: Node): Unit = {
        node.next = tail
        node.prev = tail.prev
        tail.prev.next = node
        tail.prev = node
      }

      def delTop(): Unit = {
        tail.prev.prev.next = tail
        tail.prev = tail.prev.prev
      }

      def delete(node: Node): Unit = {
        node.prev.next = node.next
        node.next.prev = node.prev
      }
    }

    private val dll = new DoubleLinkedList()
    val map: mutable.TreeMap[Int, ArrayBuffer[Node]] = mutable.TreeMap.empty[Int, ArrayBuffer[Node]]

    def push(x: Int): Unit = {
      val newNode = new Node(x)
      dll.addTop(newNode)
      map.getOrElseUpdate(x, ArrayBuffer()).append(newNode)
    }

    def pop(): Int = {
      val valTop = top()
      dll.delTop()
      val nodes = map(valTop)
      nodes.remove(nodes.size - 1)
      if (nodes.isEmpty) map.remove(valTop)
      valTop
    }

    private def top(): Int =
      dll.tail.prev.value

    def peekMax(): Int =
      map.lastKey

    def popMax(): Int = {
      val maxVal = map.lastKey
      val nodes = map(maxVal)
      val node = nodes.remove(nodes.size - 1)
      if (nodes.isEmpty) map.remove(maxVal)
      dll.delete(node)
      maxVal
    }
  }

}
