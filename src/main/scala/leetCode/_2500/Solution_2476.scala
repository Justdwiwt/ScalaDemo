package leetCode._2500

import leetCode.TreeNode

object Solution_2476 {

  def closestNodes(root: TreeNode, queries: List[Int]): List[List[Int]] = {
    @scala.annotation.tailrec
    def dfs(node: TreeNode, v: Int, lower: Int, higher: Int): List[Int] =
      if (node == null) List(lower, higher)
      else if (node.value == v) List(v, v)
      else if (node.value > v) dfs(node.left, v, lower, node.value)
      else dfs(node.right, v, node.value, higher)

    queries.map(dfs(root, _, -1, -1))
  }
}
