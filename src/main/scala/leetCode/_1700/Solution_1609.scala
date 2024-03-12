package leetCode._1700

import leetCode.TreeNode

object Solution_1609 {
  def evenF(cur: List[TreeNode]): Boolean = {
    cur.forall(_.value % 2 == 1) && cur.map(_.value).sorted.distinct == cur.map(_.value)
  }

  def oddF(cur: List[TreeNode]): Boolean = {
    cur.forall(_.value % 2 == 0) && cur.map(_.value).sorted.distinct.reverse == cur.map(_.value)
  }

  def isEvenOddTree(root: TreeNode): Boolean = {
    @scala.annotation.tailrec
    def f(curr: List[TreeNode], even: Boolean): Boolean =
      if (curr.isEmpty) true
      else {
        val next = curr.flatMap(node => Option(node.left) ++: Option(node.right) ++: List.empty)
        if (even) evenF(curr) && f(next, !even)
        else oddF(curr) && f(next, !even)
      }

    f(List(root), even = true)
  }
}
