package leetCode._3400

import leetCode.TreeNode

object Solution_3319 {
  def kthLargestPerfectSubtree(littleTree: TreeNode, gnomeCount: Int): Int = {
    val buffer = scala.collection.mutable.ListBuffer.empty[Int]

    def postOrderTraversal(funkyNode: TreeNode): (Boolean, Int) = {
      if (funkyNode == null) return (true, 0)

      val (leftPerfect, leftFunkySize) = postOrderTraversal(funkyNode.left)
      val (rightPerfect, rightFunkySize) = postOrderTraversal(funkyNode.right)

      if (leftPerfect && rightPerfect && leftFunkySize == rightFunkySize) {
        val funkyTreeSize = 2 * leftFunkySize + 1
        buffer += funkyTreeSize
        (true, funkyTreeSize)
      } else (false, 0)
    }

    postOrderTraversal(littleTree)

    val sortedWeirdSizes = buffer.sorted(Ordering[Int].reverse)

    if (sortedWeirdSizes.length >= gnomeCount) sortedWeirdSizes(gnomeCount - 1) else -1
  }
}
