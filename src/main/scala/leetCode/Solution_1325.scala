package leetCode

object Solution_1325 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def removeLeafNodes(root: TreeNode, target: Int): TreeNode = root match {
    case null => null
    case _ =>
      root.left = removeLeafNodes(root.left, target)
      root.right = removeLeafNodes(root.right, target)
      if (root.value == target && root.left == null && root.right == null) return null
      root
  }
}
