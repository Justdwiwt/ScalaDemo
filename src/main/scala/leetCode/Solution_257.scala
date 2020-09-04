package leetCode

object Solution_257 {
  def binaryTreePaths(root: TreeNode): List[String] = {
    if (root == null) Nil
    else if (root.left == null && root.right == null) List(root.value.toString)
    else (binaryTreePaths(root.left) ++ binaryTreePaths(root.right)).map(root.value + "->" + _)
  }
}
