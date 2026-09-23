package leetCode._4000

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution_3997 {
  def countDominantNodes(root: TreeNode): Int = {
    def dfs(node: TreeNode): (Int, Int) = {
      if (node == null) (0, 0)
      else {
        val (leftMax, leftCount) = dfs(node.left)
        val (rightMax, rightCount) = dfs(node.right)

        val mx = node.value.max(leftMax).max(rightMax)
        val count = leftCount + rightCount + (if (node.value == mx) 1 else 0)

        (mx, count)
      }
    }

    dfs(root)._2
  }
}
