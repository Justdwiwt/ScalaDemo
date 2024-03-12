package leetCode._200

import leetCode.TreeNode

import scala.collection.mutable

object Solution_107 {
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    val m = mutable.Map.empty[Int, List[Int]]

    def f(depth: Int, root: TreeNode): Unit = if (root != null) {
      m(depth) = m.getOrElse(depth, List.empty) :+ root.value
      f(depth + 1, root.left)
      f(depth + 1, root.right)
    }

    f(0, root)

    m
      .toList
      .sortBy(_._1)
      .map(_._2)
      .reverse
  }
}
