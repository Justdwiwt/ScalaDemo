package leetCode

object Solution_1214 {
  def twoSumBSTs(root1: TreeNode, root2: TreeNode, target: Int): Boolean = {
    if (root1 == null || root2 == null) return false
    if (root1.value + root2.value == target) return true
    if (root1.value + root2.value > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target)
    twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target)
  }
}
