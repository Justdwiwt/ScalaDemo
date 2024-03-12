package leetCode._300

object Solution_270 {
  def closestValue(root: TreeNode, target: Double): Int = {
    var t = root.value
    var cur = 0
    var node = root
    while (node != null) {
      cur = node.value
      t = if ((cur - target).abs < (t - target).abs) cur else t
      node = if (target < node.value) node.left else node.right
    }
    t
  }
}
