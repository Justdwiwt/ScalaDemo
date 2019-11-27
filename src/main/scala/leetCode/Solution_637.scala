package leetCode

object Solution_637 {
  def averageOfLevels(root: TreeNode): Array[Double] = {
    @annotation.tailrec
    def func(curLevel: List[TreeNode], res: List[Double]): Array[Double] =
      if (curLevel.isEmpty) res.reverse.toArray
      else {
        val (nextLevel, len) = curLevel.foldLeft((List.empty[TreeNode], 0)) {
          case ((ls, count), node) =>
            if (node.left != null && node.right != null) (node.left :: node.right :: ls, count + 1)
            else if (node.left != null) (node.left :: ls, count + 1)
            else if (node.right != null) (node.right :: ls, count + 1)
            else (ls, count + 1)
        }
        func(nextLevel, curLevel.map(_.value.toLong).sum.toDouble / len :: res)
      }

    if (root != null) func(List(root), List()) else Array.empty
  }
}
