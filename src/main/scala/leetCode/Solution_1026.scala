package leetCode

object Solution_1026 {
  def maxAncestorDiff(root: TreeNode, minVal: Int = 100000, maxVal: Int = 0): Int = root match {
    case null => maxVal - minVal
    case _ =>
      maxAncestorDiff(root.left, minVal.min(root.value), maxVal.max(root.value)).max(maxAncestorDiff(root.right, minVal.min(root.value), maxVal.max(root.value)))
  }
}
