package leetCode._100

object Solution_95 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def generateTrees(r: Int, l: Int = 1): List[TreeNode] =
    if (l > r) List(null)
    else (l to r).toList.flatMap(m => generateTrees(m - 1, l).flatMap(tl => generateTrees(r, m + 1).map(tr => new TreeNode(m, tl, tr))))
}
