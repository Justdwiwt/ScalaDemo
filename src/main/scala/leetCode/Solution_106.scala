package leetCode

object Solution_106 {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode =
    if (postorder.length == 0) null
    else if (postorder.length == 1) new TreeNode(postorder(0))
    else {
      var idx = postorder.length - 1
      while (idx >= 0 && inorder(idx) != postorder(postorder.length - 1)) idx -= 1
      val root = new TreeNode(postorder(postorder.length - 1))
      root.left = buildTree(inorder.slice(0, idx), postorder.slice(0, idx))
      root.right = buildTree(inorder.slice(idx + 1, postorder.length), postorder.slice(idx, postorder.length - 1))
      root
    }
}
