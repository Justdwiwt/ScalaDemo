package leetCode.offer

import leetCode.TreeNode

object Offer_046 {
  def rightSideView(root: TreeNode): List[Int] =
    f(Option(root).toSeq)

  @scala.annotation.tailrec
  def f(seq: Seq[TreeNode], list: List[Int] = Nil): List[Int] =
    if (seq.isEmpty) list
    else f(seq.flatMap(node => Seq(Option(node.left), Option(node.right)).flatten), list :+ seq.last.value)
}
