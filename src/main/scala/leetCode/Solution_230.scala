package leetCode

object Solution_230 {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    def f(root: TreeNode, cnt: Int): (Int, Option[Int]) =
      if (root == null) (cnt, None)
      else f(root.left, cnt) match {
        case (_, Some(solution: Int)) => (0, Some(solution))
        case (cnt: Int, None) if cnt == 1 => (0, Some(root.value))
        case (cnt: Int, None) => f(root.right, cnt - 1)
      }

    f(root, k)._2.get
  }
}
