package leetCode._1700

import scala.collection.mutable.ListBuffer

object Solution_1602 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def findNearestRightNode(root: TreeNode, u: TreeNode): TreeNode = {
    val list = ListBuffer[TreeNode]()
    val res = new TreeNode()
    dfs(root, u, 0, list, res)
    res.left
  }

  private def dfs(root: TreeNode, u: TreeNode, depth: Int, list: ListBuffer[TreeNode], ans: TreeNode): Unit = {
    if (ans.left != null || root == null) return
    if (depth >= list.length) list += null
    dfs(root.left, u, depth + 1, list, ans)
    if (list(depth) == u) {
      ans.left = root
      return
    }
    list(depth) = root
    dfs(root.right, u, depth + 1, list, ans)
  }
}
