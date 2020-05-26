package leetCode

object Solution_1448 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def goodNodes(root: TreeNode): Int = {
    var res = 0

    def check(root: TreeNode, curMax: Int): Unit = root match {
      case null =>
      case _ =>
        if (root.value >= curMax) res += 1
        check(root.left, curMax.max(root.value))
        check(root.right, curMax.max(root.value))
    }

    check(root, root.value)
    res
  }
}
