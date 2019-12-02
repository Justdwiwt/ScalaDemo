package leetCode

object Solution_1008 {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    if (preorder.isEmpty) null
    else {
      val res = new TreeNode(preorder.head)
      res.left = bstFromPreorder(preorder.filter(_ < preorder.head))
      res.right = bstFromPreorder(preorder.filter(_ > preorder.head))
      res
    }
  }
}
