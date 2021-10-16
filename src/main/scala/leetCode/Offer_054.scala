package leetCode

object Offer_054 {
  def convertBST(root: TreeNode): TreeNode = {
    f(List.empty[TreeNode], Option(root), 0)
    root
  }

  @scala.annotation.tailrec
  def f(stack: List[TreeNode], nodeOpts: Option[TreeNode], sum: Int): (List[TreeNode], Option[TreeNode], Int) = (stack, nodeOpts) match {
    case (Nil, None) => (stack, nodeOpts, sum)
    case (_, Some(nd)) => f(nd :: stack, Option(nd.right), sum)
    case (_, None) =>
      stack.head.value += sum
      f(stack.tail, Option(stack.head.left), stack.head.value)
  }
}
