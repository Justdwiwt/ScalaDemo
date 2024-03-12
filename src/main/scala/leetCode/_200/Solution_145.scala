package leetCode._200

import leetCode.TreeNode

object Solution_145 {
  def postorderTraversal(root: TreeNode): List[Int] = root match {
    case null => Nil
    case _ => func(root :: Nil, Nil)
  }

  @annotation.tailrec
  def func(root: List[TreeNode], res: List[Int]): List[Int] = root match {
    case h :: t =>
      val r = h.value :: res
      if (h.left != null && h.right != null) func(h.right :: h.left :: t, r)
      else if (h.left != null) func(h.left :: t, r)
      else if (h.right != null) func(h.right :: t, r)
      else func(t, r)
    case _ => res
  }
}
