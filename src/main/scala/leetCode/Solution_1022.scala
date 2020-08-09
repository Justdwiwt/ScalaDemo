package leetCode

object Solution_1022 {
  def sumRootToLeaf(root: TreeNode): Int = {
    def f(root: TreeNode, v: Int): Int = {
      if (root == null) return 0
      val t = v * 2 + root.value
      if (root.left == null && root.right == null) return t
      f(root.left, t) + f(root.right, t)
    }

    f(root, 0)
  }
}
