package leetCode

object Solution_513 {
  def findBottomLeftValue(root: TreeNode): Int = {
    @scala.annotation.tailrec
    def f(seq: List[TreeNode], res: Int): Int =
      if (seq.isEmpty) res
      else f(seq.flatMap(g), seq.head.value)

    def g(node: TreeNode): List[TreeNode] =
      Option(node.right)./:(Option(node.left)./:(List.empty[TreeNode])(_ :+ _))(_ :+ _)

    f(List(root), root.value)
  }
}
