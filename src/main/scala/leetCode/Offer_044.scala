package leetCode

object Offer_044 {
  def largestValues(root: TreeNode): List[Int] =
    f(Seq(root), Nil)

  @scala.annotation.tailrec
  def f(seq: Seq[TreeNode], res: List[Int]): List[Int] = seq match {
    case Seq() | Seq(null) => res
    case _ => f(
      seq.flatMap(n => Seq(n.left, n.right).filter(null.!=)),
      res :+ seq.map(_.value).max
    )
  }
}
