package leetCode

object Solution_230 {

  var time = 0
  var ans = 0

  def kthSmallest(root: TreeNode, k: Int): Int = {
    dfs(root, k)
    ans
  }

  def dfs(root: TreeNode, k: Int): Unit = {
    if (root == null) return
    dfs(root.left, k)
    time += 1
    if (time == k) {
      ans = root.value
      return
    }
    dfs(root.right, k)
  }

}
