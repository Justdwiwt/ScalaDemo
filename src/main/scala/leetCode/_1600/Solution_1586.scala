package leetCode._1600

import leetCode.TreeNode

import scala.collection.mutable.ListBuffer

// fixme: case 47/48 IndexOutOfBoundsException
object Solution_1586 {
  class BSTIterator(root: TreeNode) {
    private val list: ListBuffer[Int] = ListBuffer()
    private var pos: Int = -1

    buildList(root)

    private def buildList(node: TreeNode): Unit = {
      if (node == null) return
      buildList(node.left)
      list += node.value
      buildList(node.right)
    }

    def hasNext(): Boolean =
      list.size > pos + 1

    def next(): Int = {
      pos += 1
      list(pos)
    }

    def hasPrev(): Boolean = pos > 0

    def prev(): Int = {
      pos -= 1
      list(pos)
    }
  }
}
