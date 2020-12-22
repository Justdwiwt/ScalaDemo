package leetCode

object Solution_103 {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    @scala.annotation.tailrec
    def f(l2r: Boolean, seq: List[TreeNode], res: List[List[Int]]): List[List[Int]] = {
      if (seq == Nil) res
      else {
        val sq = seq.:\(List[TreeNode]())((n, acc) => (n.left, n.right) match {
          case (null, null) => acc
          case (l, null) => l :: acc
          case (null, r) => r :: acc
          case (l, r) => l :: r :: acc
        })
        if (l2r) f(l2r = false, sq, seq.map(_.value) :: res)
        else f(l2r = true, sq, seq.map(_.value).reverse :: res)
      }
    }

    if (root == null) Nil else f(l2r = true, List(root), Nil).reverse
  }
}
