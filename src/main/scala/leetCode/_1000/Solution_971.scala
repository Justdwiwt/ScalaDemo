package leetCode._1000

import leetCode.TreeNode

object Solution_971 {
  def flipMatchVoyage(root: TreeNode, voyage: Array[Int]): List[Int] = {
    var cnt = 0

    def f(root: TreeNode, res: List[Int]): List[Int] =
      if (root == null) res
      else if (root.value != voyage(cnt)) List(-1)
      else if (root.left != null && root.left.value != voyage(cnt + 1)) {
        cnt += 1
        res ++: List(root.value) ++: f(root.right, res) ++: f(root.left, res)
      } else {
        cnt += 1
        res ++: f(root.left, res) ++: f(root.right, res)
      }

    val res = f(root, Nil)
    if (res.contains(-1)) List(-1) else res
  }
}
