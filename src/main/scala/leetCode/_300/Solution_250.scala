package leetCode._300

object Solution_250 {
  def countUnivalSubtrees(root: TreeNode): Int = {
    var res = 0

    def f(node: TreeNode): Int = {
      if (node == null) Int.MaxValue
      else {
        val left = f(node.left)
        val right = f(node.right)
        if ((node.left != null && left == Int.MaxValue) || (node.right != null && right == Int.MaxValue)) Int.MaxValue
        else if ((node.left == null || left == node.value) && (node.right == null || right == node.value)) {
          res += 1
          node.value
        } else Int.MaxValue
      }
    }

    f(root)
    res
  }
}
