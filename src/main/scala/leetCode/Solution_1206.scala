package leetCode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.util.control.Breaks._

object Solution_1206 {
  class Skiplist() {

    case class Node(value: Int, _left: Node = null, _right: Node = null, _up: Node = null, _down: Node = null) {
      var left: Node = _left
      var right: Node = _right
      var up: Node = _up
      var down: Node = _down
    }

    final val DEFAULT_PROB: Double = 0.5
    final val random: Random = new Random()
    final val sentinels = ListBuffer[Node]()
    sentinels += Node(Int.MinValue)

    def search(target: Int): Boolean = {
      val smallerOrEquals = getSmallerOrEqual(target)
      smallerOrEquals.value == target
    }

    def add(num: Int): Unit = {
      val cur = getSmallerOrEqual(num)
      val toInsert = Node(num)
      append(cur, toInsert)
      populateLevelUp(toInsert)
    }

    def populateLevelUp(toInsert: Node): Unit = {
      var curLeft = toInsert.left
      var cur = toInsert

      while (flipCoin()) {
        while (curLeft.left != null && curLeft.up == null)
          curLeft = curLeft.left
        if (curLeft.up == null) {
          val newSenital = Node(Int.MinValue)
          curLeft.up = newSenital
          newSenital.down = curLeft
          sentinels += newSenital
        }
        curLeft = curLeft.up
        val newNode = Node(toInsert.value)
        cur.up = newNode
        newNode.down = cur
        cur = cur.up
        curLeft.right = cur
        cur.left = curLeft
      }
    }

    def append(prev: Node, cur: Node): Unit = {
      val next = prev.right
      prev.right = cur
      cur.left = prev

      if (next != null) {
        next.left = cur
        cur.right = next
      }
    }

    def erase(num: Int): Boolean = {
      val toRemove = getSmallerOrEqual(num)
      if (toRemove.value != num) return false

      var cur = toRemove
      while (cur != null) {
        val prev = cur.left
        val next = cur.right
        prev.right = next
        if (next != null) next.left = prev
        cur = cur.up
      }
      true
    }

    def getSmallerOrEqual(target: Int): Node = {
      var cur = sentinels.last
      breakable {
        while (cur != null) {
          if (cur.right == null || cur.right.value > target) {
            if (cur.down == null) break
            cur = cur.down
          } else cur = cur.right
        }
      }
      cur
    }

    def flipCoin(): Boolean = random.nextDouble() < DEFAULT_PROB

    override def toString: String = {
      var node = sentinels.head
      val sb = new mutable.StringBuilder()
      var i = 0
      while (node != null) {
        var itr = node
        while (itr != null) {
          if (itr.value == Int.MinValue) {
            sb.append("L" + i).append(" --> ")
            i += 1
          } else sb.append(itr.value).append(" --> ")
          itr = itr.right
        }
        sb.append("\n")
        node = node.up
      }
      sb.toString
    }

  }

}
