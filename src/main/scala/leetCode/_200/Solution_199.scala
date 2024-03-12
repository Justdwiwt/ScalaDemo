package leetCode._200

import leetCode.TreeNode

object Solution_199 {
  def rightSideView(root: TreeNode): List[Int] = f(Option(root).toSeq)

  @scala.annotation.tailrec
  def f(seq: Seq[TreeNode], list: List[Int] = Nil): List[Int] =
    if (seq.isEmpty) list
    else f(seq.flatMap(node => Seq(Option(node.left), Option(node.right)).flatten), list :+ seq.last.value)
}
