package leetCode._1000

import leetCode.TreeNode

object Solution_987 {

  case class Node(x: Int, depth: Int, value: Int)

  def verticalTraversal(root: TreeNode): List[List[Int]] = {
    val nodes = dfs(root, 0, 0)
    nodes
      .groupBy(_.x)
      .toList
      .sortBy(_._1)
      .map({ case (_, column) => column.sortBy(node => (node.depth, node.value)).map(_.value) })
  }

  def dfs(node: TreeNode, x: Int, depth: Int): List[Node] =
    if (node == null) Nil
    else Node(x, depth, node.value) :: dfs(node.left, x - 1, depth + 1) ::: dfs(node.right, x + 1, depth + 1)

}
