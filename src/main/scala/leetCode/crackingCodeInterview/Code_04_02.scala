package leetCode.crackingCodeInterview

import leetCode.TreeNode

object Code_04_02 {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.length == 0) return null
    val n = new TreeNode(nums(nums.length / 2))
    n.left = sortedArrayToBST(nums.take(nums.length / 2))
    n.right = sortedArrayToBST(nums.zipWithIndex.filter(_._2 > nums.length / 2).map(_._1))
    n
  }
}
