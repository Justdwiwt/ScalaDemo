package leetCode

object Solution_1315 {
  def sumEvenGrandparent(root: TreeNode): Int = {
    if (root == null) return 0
    var t = 0
    if (root.value % 2 == 0) {
      if (root.left != null) {
        if (root.left.left != null) t += root.left.left.value
        if (root.left.right != null) t += root.left.right.value
      }
      if (root.right != null) {
        if (root.right.left != null) t += root.right.left.value
        if (root.right.right != null) t += root.right.right.value
      }
    }
    t + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right)
  }
}
