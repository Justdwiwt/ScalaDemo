package leetCode

import scala.collection.mutable

object Solution_1261 {

  class FindElements(_root: TreeNode) {

    if (_root != null) dfs(_root, 1)

    private val s = new mutable.HashSet[Int]()

    def dfs(root: TreeNode, v: Int): Unit = {
      root.value = v - 1
      s.add(root.value)
      if (root.left != null) dfs(root.left, 2 * v)
      if (root.right != null) dfs(root.right, 2 * v + 1)
    }

    def find(target: Int): Boolean = s.contains(target)

  }

}
