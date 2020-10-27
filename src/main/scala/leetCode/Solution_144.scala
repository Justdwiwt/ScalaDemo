package leetCode

object Solution_144 {
  def preorderTraversal(root: TreeNode): List[Int] = Option(root) match {
    case Some(node) => List(node.value) ++ preorderTraversal(node.left) ++ preorderTraversal(node.right)
    case _ => List()
  }
}
