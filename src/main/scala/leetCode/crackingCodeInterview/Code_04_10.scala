package leetCode.crackingCodeInterview

import leetCode.TreeNode

object Code_04_10 {
  def checkSubTree(t1: TreeNode, t2: TreeNode): Boolean = {
    if (t2 == null) return true
    if (t1 == null) return false
    if (t1.value == t2.value) checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right)
    else checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2)
  }
}
