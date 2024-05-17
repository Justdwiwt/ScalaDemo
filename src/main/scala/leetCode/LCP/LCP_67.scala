package leetCode.LCP

object LCP_67 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  // fixme: case 51/61 memory limit exceeded
  def expandBinaryTree(root: TreeNode): TreeNode = {
    if (root == null || (root.left == null && root.right == null)) return root
    if (root.left != null) root.left = new TreeNode(-1, expandBinaryTree(root.left), null)
    if (root.right != null) root.right = new TreeNode(-1, null, expandBinaryTree(root.right))
    root
  }

}
