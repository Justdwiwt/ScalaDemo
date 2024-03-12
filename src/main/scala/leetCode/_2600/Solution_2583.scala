package leetCode._2600

import leetCode.TreeNode

object Solution_2583 {
  def kthLargestLevelSum(root: TreeNode, k: Int): Long = {
    val sums = f(List(root), List.empty).sorted.reverse
    if (sums.size < k) -1 else sums(k - 1)
  }

  @scala.annotation.tailrec
  private def f(nodes: List[TreeNode], acc: List[Long]): List[Long] = {
    val nAcc = nodes.map(_.value)./:(0L)(_ + _) :: acc
    val next = nodes.flatMap(n => List(n.left, n.right)).filter(_ != null)
    if (next.isEmpty) nAcc else f(next, nAcc)
  }
}
