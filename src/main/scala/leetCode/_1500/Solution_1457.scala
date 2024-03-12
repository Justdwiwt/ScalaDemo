package leetCode._1500

object Solution_1457 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def pseudoPalindromicPaths(root: TreeNode): Int = {
    if (root == null) return 0
    var res = 0
    dfs(root, 0)

    def dfs(root: TreeNode, t: Int): Unit = {
      val n = t ^ (1 << root.value)
      if (root.left == null && root.right == null) {
        if (n == 0 || (n & (n - 1)) == 0) res += 1
        return
      }
      if (root.left != null) dfs(root.left, n)
      if (root.right != null) dfs(root.right, n)
    }

    res
  }
}
