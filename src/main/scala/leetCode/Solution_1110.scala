package leetCode

import scala.collection.mutable

object Solution_1110 {
  def delNodes(root: TreeNode, to_delete: Array[Int]): List[TreeNode] = {
    var res = List.empty[TreeNode]
    val s = new mutable.HashSet[Int]()
    to_delete.foreach(i => s.add(i))

    def dfs(parent: TreeNode, root: TreeNode, set: mutable.HashSet[Int]): Unit = {
      if (root == null) return
      dfs(root, root.left, set)
      dfs(root, root.right, set)
      if (set.contains(root.value)) {
        if (parent != null && parent.left == root) parent.left = null
        if (parent != null && parent.right == root) parent.right = null
        if (root.left != null) res :+= root.left
        if (root.right != null) res :+= root.right
      }
    }

    dfs(null, root, s)
    if (!s.contains(root.value)) res :+= root
    res
  }
}
