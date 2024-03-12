package leetCode._1000

import leetCode.TreeNode

object Solution_938 {
  def add(x: Int, y: Int): Int = x + y

  def between(x: Int, y: Int)(i: Int): Boolean = i >= x && y >= i

  def collectNode(node: TreeNode): List[Option[Int]] = {
    def tramp(value: Any): List[Option[Int]] = value match {
      case x: TreeNode => collectNode(x)
      case x: Int => List(Option(x))
      case _ => List(None)
    }

    Option(node.value) :: tramp(node.left) ::: tramp(node.right)
  }

  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = collectNode(root)
    .flatten
    .filter(between(L, R))
    .reduce(add)
}
