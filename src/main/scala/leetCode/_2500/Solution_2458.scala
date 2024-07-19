package leetCode._2500

import leetCode.TreeNode

import scala.collection.mutable

object Solution_2458 {
  private def calculateHeights(root: TreeNode): mutable.Map[TreeNode, Int] = {
    val heights = mutable.Map.empty[TreeNode, Int]
    val stack = mutable.Stack[(TreeNode, Boolean)]()
    stack.push((root, false))

    while (stack.nonEmpty) {
      val (node, processed) = stack.pop()
      if (node != null) {
        if (processed) {
          val leftHeight = heights.getOrElse(node.left, 0)
          val rightHeight = heights.getOrElse(node.right, 0)
          heights(node) = 1 + leftHeight.max(rightHeight)
        } else {
          stack.push((node, true))
          stack.push((node.right, false))
          stack.push((node.left, false))
        }
      }
    }
    heights
  }

  private def calculateAnswers(root: TreeNode, heights: mutable.Map[TreeNode, Int]): Array[Int] = {
    val res = mutable.Map.empty[Int, Int]
    val stack = mutable.Stack[(TreeNode, Int, Int)]()
    stack.push((root, 0, -1))

    while (stack.nonEmpty) {
      val (node, d, ans) = stack.pop()
      if (node != null) {
        res(node.value) = ans
        val rightHeight = heights.getOrElse(node.right, 0)
        val leftHeight = heights.getOrElse(node.left, 0)

        stack.push((node.left, d + 1, math.max(ans, rightHeight + d)))
        stack.push((node.right, d + 1, math.max(ans, leftHeight + d)))
      }
    }

    val maxVal = heights.keys.map(_.value).max
    (0 to maxVal).map(res.getOrElse(_, 0)).toArray
  }

  def treeQueries(root: TreeNode, queries: Array[Int]): Array[Int] = {
    val heights = calculateHeights(root)
    val res = calculateAnswers(root, heights)
    queries.map(res)
  }
}
