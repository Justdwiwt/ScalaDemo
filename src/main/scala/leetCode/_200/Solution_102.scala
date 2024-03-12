package leetCode._200

import leetCode.TreeNode

object Solution_102 {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    f(if (root == null) Nil else List(root), Nil)
  }

  @scala.annotation.tailrec
  def f(queue: List[TreeNode], res: List[List[Int]]): List[List[Int]] = {
    if (queue.isEmpty) res
    else f(queue.flatMap(n => List(n.left, n.right)).filter(_ != null), res :+ queue.map(_.value))
  }
}
