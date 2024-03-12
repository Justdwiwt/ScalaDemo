package leetCode._1000

import leetCode.TreeNode

object Solution_979 {
  def distributeCoins(root: TreeNode): Int = {
    if (root == null) return 0
    val left = func(root.left)
    val right = func(root.right)
    val cost = (left._1 - left._2).abs + (right._1 - right._2).abs
    cost + distributeCoins(root.left) + distributeCoins(root.right)
  }

  def func(root: TreeNode): (Int, Int) = root match {
    case null => (0, 0)
    case _ =>
      val left = func(root.left)
      val right = func(root.right)
      (1 + left._1 + right._1, root.value + left._2 + right._2)
  }
}
