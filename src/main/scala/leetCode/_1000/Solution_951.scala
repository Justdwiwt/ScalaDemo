package leetCode._1000

import leetCode.TreeNode

object Solution_951 {
  def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = (getValue(root1), getValue(root2)) match {
    case (None, None) => true
    case (Some(x), Some(y)) => if (x == y) {
      if (getValue(root1.left) == getValue(root2.left)) flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
      else flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
    } else false
    case _ => false
  }

  def getValue(root: TreeNode): Option[Int] = root match {
    case null => None
    case _ => Some(root.value)
  }
}
