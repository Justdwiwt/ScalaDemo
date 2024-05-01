package leetCode._1200

object Solution_1120 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def maximumAverageSubtree(root: TreeNode): Double = {
    def dfs(root: TreeNode): Array[Double] = {
      if (root == null) return Array(0, 0, 0)

      val Array(leftSum, leftCount, leftAvg) = dfs(root.left)
      val Array(rightSum, rightCount, rightAvg) = dfs(root.right)

      val valSum = leftSum + rightSum + root.value
      val nodeCount = leftCount + rightCount + 1

      Array(valSum, nodeCount, List(leftAvg, rightAvg, valSum / nodeCount).max)
    }

    val Array(_, _, avg) = dfs(root)
    avg
  }
}
