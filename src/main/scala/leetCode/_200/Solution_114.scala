package leetCode._200

import leetCode.TreeNode

object Solution_114 {
  def flatten(root: TreeNode): Unit = {
    var cur = root
    while (cur != null) {
      if (cur.left != null) {
        var p = cur.left
        while (p.right != null) p = p.right
        p.right = cur.right
        cur.right = cur.left
        cur.left = null
      }
      cur = cur.right
    }
  }
}
