package leetCode._2500

import leetCode.TreeNode

object Solution_2415 {
  def reverseOddLevels(root: TreeNode): TreeNode = {
    reverse(root.left, root.right, flag = true)
    root
  }

  def swap(l: TreeNode, r: TreeNode): Unit = {
    val t = l.value
    l.value = r.value
    r.value = t
  }

  def reverse(l: TreeNode, r: TreeNode, flag: Boolean): Unit = {
    if (l == null) return
    if (flag) swap(l, r)
    reverse(l.left, r.right, !flag)
    reverse(l.right, r.left, !flag)
  }
}
