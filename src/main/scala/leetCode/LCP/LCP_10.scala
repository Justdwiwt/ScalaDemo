package leetCode.LCP

import leetCode.TreeNode

object LCP_10 {
  def minimalExecTime(root: TreeNode): Double = {
    def time(node: TreeNode, n: Int): Array[Double] = {
      if (node == null) return Array(0.0D, 0.0D)
      val l = time(node.left, n)
      val r = time(node.right, n)
      val sum = l(1) + r(1)
      val min = l.head.max(r.head).max(sum / n) + node.value
      Array(min, sum + node.value)
    }

    time(root, 2).head
  }
}
