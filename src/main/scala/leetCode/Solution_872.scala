package leetCode

object Solution_872 {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean =
    f(Seq(root1)) == f(Seq(root2))

  @scala.annotation.tailrec
  def f(nodes: Seq[TreeNode]): Seq[Int] =
    if (nodes.exists(n => n.left != null || n.right != null))
      f(nodes.flatMap(n => if (n.left == null && n.right == null) Seq(n) else Seq(n.left, n.right).filter(null.!=)))
    else nodes.map(_.value)
}
