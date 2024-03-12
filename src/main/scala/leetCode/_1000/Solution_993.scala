package leetCode._1000

import leetCode.TreeNode

object Solution_993 {
  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    def f(n: Int, parent: Int, node: TreeNode, depth: Int): Option[(Int, Int)] =
      if (n == node.value) Some(depth, parent)
      else Option(node.left).flatMap(f(n, node.value, _, depth + 1))
        .orElse(Option(node.right).flatMap(f(n, node.value, _, depth + 1)))

    f(x, root.value, root, 0)
      .zip(f(y, root.value, root, 0))
      .exists(pair => pair._1._2 != pair._2._2 && pair._1._1 == pair._2._1)
  }
}
