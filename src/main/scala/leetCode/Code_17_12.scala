package leetCode

object Code_17_12 {
  private var node: TreeNode = _

  def convertBiNode(root: TreeNode): TreeNode = {
    if (root == null) return null
    convertBiNode(root.right)
    root.right = node
    node = root
    convertBiNode(root.left)
    root.left = null
    node
  }
}
