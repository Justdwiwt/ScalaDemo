package leetCode

object Solution_563 {
  def findTilt(root: TreeNode): Int = {
    if (root == null) 0
    else abs(traverse(root.left) - traverse(root.right)) + findTilt(root.left) + findTilt(root.right)
  }

  def traverse(root: TreeNode): Int = {
    if (root == null) 0
    else root.value + traverse(root.left) + traverse(root.right)
  }

  def abs(n: Int): Int = if (n < 0) -n else n
}
