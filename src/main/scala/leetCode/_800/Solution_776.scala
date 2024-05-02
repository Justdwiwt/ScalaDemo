package leetCode._800

object Solution_776 {
  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

  def splitBST(root: TreeNode, target: Int): Array[TreeNode] = {
    def split(node: TreeNode, target: Int): (TreeNode, TreeNode) =
      if (node == null) (null, null)
      else if (node.value <= target) {
        val (smallerRight, biggerRight) = split(node.right, target)
        (TreeNode(node.value, node.left, smallerRight), biggerRight)
      } else {
        val (smallerLeft, biggerLeft) = split(node.left, target)
        (smallerLeft, TreeNode(node.value, biggerLeft, node.right))
      }

    val (smaller, bigger) = split(root, target)
    Array(smaller, bigger)
  }
}
