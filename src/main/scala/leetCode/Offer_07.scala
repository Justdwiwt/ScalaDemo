package leetCode

object Offer_07 {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder.isEmpty || inorder.isEmpty) return null
    func(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1)
  }

  def func(preorder: Array[Int], _a1: Int, _b1: Int, inorder: Array[Int], _a2: Int, _b2: Int): TreeNode = {
    val root = new TreeNode(preorder(_a1))
    var t = _a2
    while (inorder(t) != preorder(_a1)) t += 1
    val left = t - _a2
    val right = _b2 - t
    if (left > 0) root.left = func(preorder, _a1 + 1, _a1 + left, inorder, _a2, t - 1)
    if (right > 0) root.right = func(preorder, _a1 + left + 1, _b1, inorder, t + 1, _b2)
    root
  }
}
