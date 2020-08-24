package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_662 {
  def widthOfBinaryTree(root: TreeNode): Int = {
    var res = 0
    dfs(root, 1, 1, new ArrayBuffer[Int]())

    def dfs(r: TreeNode, level: Int, idx: Int, left: ArrayBuffer[Int]): Unit = {
      if (r == null) return
      if (level > left.length) left.append(idx)
      res = res.max(idx - left(level - 1) + 1)
      dfs(r.left, level + 1, idx * 2, left)
      dfs(r.right, level + 1, idx * 2 + 1, left)
    }

    res
  }
}
