package leetCode._700

import leetCode.TreeNode

object Solution_654 {
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = nums./:(List.empty[TreeNode])((stack, num) => {
    val newNode = new TreeNode(num)
    val (small, large) = stack.span(_.value < num)
    small.lastOption.foreach(newNode.left = _)
    large.headOption.foreach(_.right = newNode)
    newNode :: large
  }).last
}
