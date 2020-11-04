package leetCode

import scala.collection.mutable.ListBuffer

object Solution_366 {
  def findLeaves(root: TreeNode): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]

    def f(root: TreeNode, res: ListBuffer[List[Int]]): Int = {
      if (root == null) return -1
      val t = f(root.left, res).max(f(root.right, res)) + 1
      if (res.length <= t) res += Nil
      res(t) ::= root.value
      t
    }

    f(root, res)
    res.toList
  }
}
