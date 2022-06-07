package leetCode

object Code_04_12 {
  def pathSum(root: TreeNode, sum: Int): Int = {
    if (null == root) return 0
    f(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
  }

  def f(node: TreeNode, _sum: Int): Int = {
    if (null == node) return 0
    var sum = _sum
    sum -= node.value
    var cnt = if (sum == 0) 1 else 0
    cnt += f(node.left, sum)
    cnt += f(node.right, sum)
    cnt
  }
}
