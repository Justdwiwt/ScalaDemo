package leetCode.offer

import leetCode.TreeNode

object Offer_26 {
  def isSubStructure(A: TreeNode, B: TreeNode): Boolean = {
    if (A == null || B == null) return false
    f(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
  }

  def f(A: TreeNode, B: TreeNode): Boolean = {
    if (A == null || B == null) return if (B == null) true else false
    if (A.value != B.value) return false
    f(A.left, B.left) && f(A.right, B.right)
  }
}
