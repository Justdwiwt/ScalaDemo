package leetCode.offer

import leetCode.TreeNode

object Offer_68_1 {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = root match {
    case null => null
    case _ =>
      if (p.value > root.value && q.value > root.value) return lowestCommonAncestor(root.right, p, q)
      if (p.value < root.value && q.value < root.value) return lowestCommonAncestor(root.left, p, q)
      root
  }
}
