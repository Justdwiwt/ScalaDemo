package leetCode

object Solution_450 {
  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    var t = root
    if (t == null) return null
    if (t.value > key) t.left = deleteNode(t.left, key)
    else if (t.value < key) t.right = deleteNode(t.right, key)
    else {
      if (t.left == null || t.right == null) t = if (t.left != null) t.left else t.right
      else {
        var cur = t.right
        while (cur.left != null) cur = cur.left
        t.value = cur.value
        t.right = deleteNode(t.right, cur.value)
      }
    }
    t
  }
}
