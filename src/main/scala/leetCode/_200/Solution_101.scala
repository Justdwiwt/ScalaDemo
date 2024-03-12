package leetCode._200

import leetCode.TreeNode

object Solution_101 {
  def f(root: TreeNode, ref: TreeNode): Boolean = (Option(root), Option(ref)) match {
    case (None, Some(_)) | (Some(_), None) => false
    case (None, None) => true
    case (Some(root), Some(ref)) =>
      Seq(root.value == ref.value, f(root.left, ref.right), f(root.right, ref.left)).reduce(_ && _)
  }

  def isSymmetric(root: TreeNode): Boolean = Option(root) match {
    case None => true
    case Some(root) => f(root.left, root.right)
  }
}
