package leetCode.offer

import leetCode.TreeNode

object XH_15_3 {
  @scala.annotation.tailrec
  def maximumValueInBST(root: TreeNode): Int = {
    if (root == null) 0
    else if (root.right == null) root.value
    else maximumValueInBST(root.right)
  }
}
