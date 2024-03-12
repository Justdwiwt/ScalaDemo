package leetCode._1400

object Solution_1373 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def maxSumBST(root: TreeNode): Int = {
    var res = 0
    dfs(root)

    def dfs(root: TreeNode): Array[Int] = root match {
      case null => Array(1, Int.MaxValue, Int.MinValue, 0)
      case _ =>
        val l = dfs(root.left)
        val r = dfs(root.right)
        var sum = 0
        var mx = 0
        var mn = 0
        if (l(0) != 1 || r(0) != 1 || root.value >= r(1) || root.value <= l(2)) return Array(0, 0, 0, 0)
        mn = if (root.left != null) l(1) else root.value
        mx = if (root.right != null) r(2) else root.value
        sum += (root.value + l(3) + r(3))
        res = res.max(sum)
        Array(1, mn, mx, sum)
    }

    res
  }
}
