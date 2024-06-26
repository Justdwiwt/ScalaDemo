package leetCode._800

import leetCode.TreeNode

object Solution_783 {
  private def dfs(root: TreeNode): List[Int] =
    if (root == null) Nil
    else dfs(root.left) ::: List(root.value) ::: dfs(root.right)

  def minDiffInBST(root: TreeNode): Int = {
    val ordered = dfs(root)
    ordered.zip(ordered.tail).map { case (a, b) => (a - b).abs }.min
  }
}
