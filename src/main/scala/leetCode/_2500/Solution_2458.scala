package leetCode._2500

import leetCode.TreeNode

import scala.collection.mutable

// fixme: case 37/40 stack overflow
object Solution_2458 {
  private val height = mutable.Map[TreeNode, Int]()
  private var res: Array[Int] = _

  def treeQueries(root: TreeNode, queries: Array[Int]): Array[Int] = {
    getHeight(root)
    height(null) = 0
    res = new Array[Int](height.size)
    dfs(root, -1, 0)
    queries.indices.foreach(i => queries(i) = res(queries(i)))
    queries
  }

  private def getHeight(node: TreeNode): Int =
    if (node == null) 0
    else {
      val h = 1 + Math.max(getHeight(node.left), getHeight(node.right))
      height(node) = h
      h
    }

  private def dfs(node: TreeNode, depth: Int, restH: Int): Unit =
    if (node != null) {
      val newDepth = depth + 1
      res(node.value) = restH
      dfs(node.left, newDepth, math.max(restH, newDepth + height.getOrElse(node.right, 0)))
      dfs(node.right, newDepth, math.max(restH, newDepth + height.getOrElse(node.left, 0)))
    }
}
