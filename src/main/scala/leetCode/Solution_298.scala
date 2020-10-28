package leetCode

object Solution_298 {
  def longestConsecutive(root: TreeNode): Int = {
    def f(p: TreeNode, parent: TreeNode, length: Int): Int = {
      if (p == null) return length
      val t = if (parent != null && p.value == parent.value + 1) length + 1 else 1
      t.max(f(p.left, p, t).max(f(p.right, p, t)))
    }

    f(root, null, 0)
  }
}
