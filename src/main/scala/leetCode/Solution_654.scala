package leetCode

object Solution_654 {
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = nums./:(List.empty[TreeNode])((stack, num) => {
    val newNode = new TreeNode(num)
    val (small, large) = stack.span(_.value < num)
    small.lastOption.foreach(nd => newNode.left = nd)
    large.headOption.foreach(nd => nd.right = newNode)
    newNode :: large
  }).last
}
