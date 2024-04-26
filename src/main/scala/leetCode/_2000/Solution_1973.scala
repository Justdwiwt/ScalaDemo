package leetCode._2000

import leetCode.TreeNode

object Solution_1973 {
  // fixme: case 64/101 stack overflow
  def equalToDescendants(root: TreeNode): Int = {
    def f(x: TreeNode, res: Int): (Int, Int) = {
      if (x == null) (0, res)
      else {
        val (a, res1) = f(x.left, res)
        val (b, res2) = f(x.right, res1)
        if (x.value == a + b) (x.value + x.value, res2 + 1)
        else (x.value + a + b, res2)
      }
    }

    f(root, 0)._2
  }
}
