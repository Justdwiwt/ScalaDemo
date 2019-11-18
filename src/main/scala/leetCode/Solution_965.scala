package leetCode

object Solution_965 {
  def isUnivalTree(root: TreeNode): Boolean = root match {
    case null => true
    case _ => func(root.right, root.value) && func(root.left, root.value)
  }

  def func(root: TreeNode, value: Int): Boolean = root match {
    case null => true
    case node: TreeNode if node.value == value => func(node.left, value) && func(node.right, value)
    case _ => false
  }
}
