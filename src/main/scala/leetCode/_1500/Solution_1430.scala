package leetCode._1500

import leetCode.TreeNode

object Solution_1430 {
  def isValidSequence(root: TreeNode, arr: Array[Int]): Boolean = {
    f(root, arr, 0)
  }

  def f(root: TreeNode, arr: Array[Int], idx: Int): Boolean = {
    if (root == null || root.value != arr(idx)) return false
    if (idx == arr.length - 1) return root.left == null && root.right == null
    f(root.left, arr, idx + 1) || f(root.right, arr, idx + 1)
  }
}
