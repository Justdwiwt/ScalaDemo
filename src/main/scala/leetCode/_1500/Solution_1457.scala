package leetCode._1500

object Solution_1457 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def pseudoPalindromicPaths(root: TreeNode): Int = {
    def dfs(node: TreeNode, bitmask: Int): Int = {
      val newBitmask = 1 << node.value ^ bitmask
      if (node.left == null && node.right == null)
        if ((1 to 9).count(shift => (newBitmask >> shift & 1) > 0) <= 1) 1
        else 0
      else Seq(Option(node.left), Option(node.right)).flatten.map(dfs(_, newBitmask)).sum
    }

    dfs(root, 0)
  }
}
