package leetCode

object Solution_814 {
  def pruneTree(root: TreeNode): TreeNode = {
    if (root == null) return null
    root.left = pruneTree(root.left)
    root.right = pruneTree(root.right)
    if (root.left == null && root.right == null && root.value == 0) null
    else root
  }
}
