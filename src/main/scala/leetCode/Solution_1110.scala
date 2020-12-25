package leetCode

object Solution_1110 {
  def delNodes(root: TreeNode, to_delete: Array[Int]): List[TreeNode] = {
    val st = to_delete.toSet
    var res = List.empty[TreeNode]
    if (!st.contains(root.value)) res = root :: res

    def f(cur: TreeNode, remove: () => Unit): Unit = {
      if (cur.left != null) f(cur.left, () => cur.left = null)
      if (cur.right != null) f(cur.right, () => cur.right = null)
      if (st.contains(cur.value)) {
        if (cur.left != null) res = cur.left :: res
        if (cur.right != null) res = cur.right :: res
        remove()
      }
    }

    f(root, () => ())
    res
  }
}
