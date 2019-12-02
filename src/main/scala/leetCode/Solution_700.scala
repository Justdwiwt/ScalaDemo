package leetCode

object Solution_700 {
  @scala.annotation.tailrec
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) return null
    if (root.value == `val`) return root
    if (root.value > `val`) searchBST(root.left, `val`) else searchBST(root.right, `val`)
  }
}
