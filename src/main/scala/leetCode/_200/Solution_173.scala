package leetCode._200

import leetCode.TreeNode

object Solution_173 {

  class BSTIterator(_root: TreeNode) {
    private var stack = pushLefts(_root, Nil)

    @scala.annotation.tailrec
    private def pushLefts(node: TreeNode, acc: List[TreeNode]): List[TreeNode] =
      if (node == null) acc
      else pushLefts(node.left, node :: acc)

    def next(): Int = stack match {
      case x :: xs =>
        stack = pushLefts(x.right, xs)
        x.value
      case Nil => throw new NoSuchElementException
    }

    def hasNext(): Boolean = stack.nonEmpty
  }

}
