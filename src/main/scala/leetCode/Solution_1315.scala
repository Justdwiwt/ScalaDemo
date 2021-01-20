package leetCode

object Solution_1315 {
  def sumEvenGrandparent(root: TreeNode): Int =
    f(Option(root))

  def f(nodeOpts: Option[TreeNode]): Int = nodeOpts match {
    case Some(nd) if nd.value % 2 == 0 => cal(nd)(cal(_)(_.value)) + f(Option(nd.left)) + f(Option(nd.right))
    case Some(nd) => f(Option(nd.left)) + f(Option(nd.right))
    case None => 0
  }

  def cal(nd: TreeNode)(f: TreeNode => Int): Int =
    Option(nd.left).fold(0)(f) + Option(nd.right).fold(0)(f)
}
