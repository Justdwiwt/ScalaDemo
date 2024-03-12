package leetCode._700

object Solution_617 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    (Option(t1), Option(t2)) match {
      case (Some(_), Some(_)) =>
        val newValue = t1.value + t2.value
        val newLeft = mergeTrees(t1.left, t2.left)
        val newRight = mergeTrees(t1.right, t2.right)
        new TreeNode(newValue, newLeft, newRight)
      case (Some(l), None) => l
      case (None, Some(r)) => r
      case (None, None) => null
    }
  }
}
