package leetCode

object Solution_971 {
  def flipMatchVoyage(root: TreeNode, voyage: Array[Int]): List[Int] = {
    val res = solver(root, voyage)
    if (res.contains(-1)) List(-1) else res
  }

  def solver(root: TreeNode, voyage: Array[Int]): List[Int] = root match {
    case null => List.empty
    case node: TreeNode if node.value != voyage.head => List(-1)
    case node: TreeNode if node.left == null && node.right == null => List.empty
    case node: TreeNode if node.left != null && node.right == null => solver(node.left, voyage.tail)
    case node: TreeNode if node.left == null && node.right != null => solver(node.right, voyage.tail)
    case node: TreeNode if node.left != null && node.right != null =>
      val nl = countNode(root.left)
      val nr = countNode(root.right)
      val ml = root.left.value == voyage.tail.head
      val mr = root.right.value == voyage.tail.head
      (ml, mr) match {
        case (true, false) => solver(root.left, voyage.slice(1, nl + 1)) ::: solver(root.right, voyage.slice(nl + 1, voyage.length))
        case (false, true) => root.value :: solver(root.right, voyage.slice(1, nr + 1)) ::: solver(root.left, voyage.slice(nr + 1, voyage.length))
        case _ => List(-1)
      }
  }

  def countNode(root: TreeNode): Int = root match {
    case null => 0
    case _ => 1 + countNode(root.left) + countNode(root.right)
  }
}
