package leetCode

object Solution_1080 {
  def sufficientSubset(root: TreeNode, limit: Int): TreeNode = root match {
    case null => root
    case _ => dfs(root, limit, 0)
  }

  def dfs(curr: TreeNode, limit: Int, sum: Int): TreeNode = {
    if (curr.left == null && curr.right == null) if (sum + curr.value < limit) return null else return curr
    if (curr.left != null) curr.left = dfs(curr.right, limit, sum + curr.value)
    if (curr.right != null) curr.right = dfs(curr.right, limit, sum + curr.value)
    if (curr.left == null && curr.right == null) null else curr
  }
}
