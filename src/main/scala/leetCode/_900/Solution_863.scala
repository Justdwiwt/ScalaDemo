package leetCode._900

import leetCode.TreeNode

object Solution_863 {
  def distanceK(root: TreeNode, target: TreeNode, K: Int): List[Int] = {
    val below = findKBelow(target, K)
    if (target == root || K == 0) below
    else {
      val annotated = annotateParents(root).toMap
      val above = findKAbove(target, K, annotated)
      below ::: above
    }
  }

  def findKAbove(cur: TreeNode, n: Int, parents: Map[TreeNode, TreeNode]): List[Int] =
    if (n == 0) List(cur.value)
    else parents(cur) match {
      case null => Nil
      case p if p.left == cur => findKBelow(p.right, n - 2) ::: findKAbove(p, n - 1, parents)
      case p => findKBelow(p.left, n - 2) ::: findKAbove(p, n - 1, parents)
    }

  def findKBelow(root: TreeNode, n: Int): List[Int] =
    if (root == null) Nil
    else if (n == 0) List(root.value)
    else findKBelow(root.left, n - 1) ::: findKBelow(root.right, n - 1)

  def annotateParents(cur: TreeNode, parent: TreeNode = null): List[(TreeNode, TreeNode)] =
    if (cur == null) Nil
    else (cur, parent) +: annotateParents(cur.left, cur) ::: annotateParents(cur.right, cur)
}
