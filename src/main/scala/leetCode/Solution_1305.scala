package leetCode

object Solution_1305 {
  def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] =
    (inorder(Option(root1)) ++ inorder(Option(root2))).sorted

  def inorder(node: Option[TreeNode]): List[Int] =
    node.fold(List.empty[Int])(nd => inorder(Option(nd.left)) ::: (nd.value :: inorder(Option(nd.right))))
}
