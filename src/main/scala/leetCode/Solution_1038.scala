package leetCode

object Solution_1038 {
  def bstToGst(root: TreeNode): TreeNode = {
    func(root, 0)
    root
  }

  def func(tree: TreeNode, parent: Int): Int = tree match {
    case null => parent
    case _ =>
      var right = func(tree.right, parent)
      tree.value += right
      func(tree.left, tree.value)
  }
}
