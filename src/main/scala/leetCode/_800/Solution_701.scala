package leetCode._800

import leetCode.TreeNode

object Solution_701 {
  def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) return new TreeNode(`val`)
    if (root.value > `val`) root.left = insertIntoBST(root.left, `val`)
    else root.right = insertIntoBST(root.right, `val`)
    root
  }
}
