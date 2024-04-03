package leetCode._700

object Solution_623 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def addOneRow(root: TreeNode, value: Int, depth: Int): TreeNode =
    if (depth == 1) new TreeNode(value, _left = root)
    else {
      (2 until depth).foldLeft(Seq(root)) {
        case (nodes, _) => nodes.flatMap(node => Seq.empty ++ Option(node.left) ++ Option(node.right))
      }.foreach(node => {
        node.left = new TreeNode(value, _left = node.left)
        node.right = new TreeNode(value, _right = node.right)
      })
      root
    }
}
