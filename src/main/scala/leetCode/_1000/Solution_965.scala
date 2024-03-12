package leetCode._1000

import leetCode.TreeNode

object Solution_965 {
  def isUnivalTree(root: TreeNode): Boolean = {
    @scala.annotation.tailrec
    def f(curr: List[TreeNode]): Boolean = curr match {
      case Nil => true
      case _ =>
        val next = curr.flatMap(node => List(node.left, node.right)).filter(_ != null)
        if (next.exists(_.value != root.value)) false
        else f(next)
    }

    f(if (root == null) Nil else List(root))
  }
}
