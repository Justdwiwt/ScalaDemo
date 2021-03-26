package leetCode

object Solution_700 {
  @scala.annotation.tailrec
  def searchBST(root: TreeNode, `val`: Int): TreeNode = (root, `val`) match {
    case (null, _) => null
    case (root, `val`) if root.value > `val` => searchBST(root.left, `val`)
    case (root, `val`) if root.value < `val` => searchBST(root.right, `val`)
    case (root, `val`) if root.value == `val` => root
  }
}
