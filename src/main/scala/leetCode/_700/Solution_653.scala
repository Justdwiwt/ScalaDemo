package leetCode._700

import leetCode.TreeNode

object Solution_653 {
  def findTarget(root: TreeNode, k: Int): Boolean =
    f(root, k, scala.collection.mutable.Set.empty[Int])

  def f(node: TreeNode, k: Int, values: scala.collection.mutable.Set[Int]): Boolean = node match {
    case n if n == null => false
    case s if values.contains(k - s.value) => true
    case r =>
      values += r.value
      f(r.left, k, values) || f(r.right, k, values)
  }
}
