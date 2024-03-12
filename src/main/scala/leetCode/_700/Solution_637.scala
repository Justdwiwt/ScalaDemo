package leetCode._700

import leetCode.TreeNode

object Solution_637 {
  def averageOfLevels(root: TreeNode): Array[Double] = {
    @scala.annotation.tailrec
    def f(cur: List[TreeNode], res: List[Double]): Array[Double] =
      if (cur.isEmpty) res.reverse.toArray
      else {
        val (next, len) = cur./:(List.empty[TreeNode], 0) {
          case ((ls, cnt), node) =>
            if (node.left != null && node.right != null) (node.left :: node.right :: ls, cnt + 1)
            else if (node.left != null) (node.left :: ls, cnt + 1)
            else if (node.right != null) (node.right :: ls, cnt + 1)
            else (ls, cnt + 1)
        }
        f(next, cur.map(_.value.toLong).sum.toDouble / len :: res)
      }

    if (root != null) f(List(root), Nil) else Array.empty
  }
}
