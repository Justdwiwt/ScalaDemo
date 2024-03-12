package leetCode._300

object Solution_285 {
  def inorderSuccessor(root: TreeNode, p: TreeNode): TreeNode = {
    if (p == null || root == null) return null
    if (root.value <= p.value) return inorderSuccessor(root.right, p)
    val res = inorderSuccessor(root.left, p)
    if (res != null && res.value < root.value) res else root
  }
}
