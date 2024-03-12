package leetCode._700

import leetCode.TreeNode

object Solution_669 {
  def trimBST(root: TreeNode, l: Int, r: Int): TreeNode = (root, l, r) match {
    case (null, _, _) => null
    case (root, l, r) if l > root.value => trimBST(root.right, l, r)
    case (root, l, r) if r < root.value => trimBST(root.left, l, r)
    case (root, l, r) =>
      root.left = trimBST(root.left, l, r)
      root.right = trimBST(root.right, l, r)
      root
  }
}
