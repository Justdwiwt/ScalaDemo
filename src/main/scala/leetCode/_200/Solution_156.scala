package leetCode._200

import leetCode.TreeNode

object Solution_156 {
  def upsideDownBinaryTree(root: TreeNode): TreeNode = {
    if (root == null) null else dfs(null, root)
  }

  def dfs(parent: TreeNode, node: TreeNode): TreeNode = {
    val t = if (node.left == null) node else dfs(node, node.left)
    node.left = if (parent == null) null else parent.right
    node.right = parent
    t
  }
}
