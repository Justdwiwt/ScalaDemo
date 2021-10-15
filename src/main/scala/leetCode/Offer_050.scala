package leetCode

object Offer_050 {
  def pathSum(root: TreeNode, sum: Int): Int =
    if (root == null) 0
    else dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)

  def dfs(root: TreeNode, sum: Int): Int =
    if (root == null) 0
    else (if (root.value == sum) 1 else 0) + dfs(root.left, sum - root.value) + dfs(root.right, sum - root.value)
}
