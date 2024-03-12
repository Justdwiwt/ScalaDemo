package leetCode._1100

import leetCode.TreeNode

object Solution_1022 {
  def f(root: TreeNode, L: List[List[Int]], l: List[Int]): List[List[Int]] =
    if (root == null) l :: L
    else if (root.left == null) f(root.right, L, root.value :: l)
    else if (root.right == null) f(root.left, L, root.value :: l)
    else f(root.left, L, root.value :: l) ++ f(root.right, L, root.value :: l)

  def sumRootToLeaf(root: TreeNode): Int = f(root, Nil, Nil)
    .map(_.reverse)
    .map(_./:(0)((s, t) => 2 * s + t))
    .sum
}
