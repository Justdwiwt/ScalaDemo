package leetCode

object Solution_572 {
  def isSubtree(s: TreeNode, t: TreeNode): Boolean = s match {
    case null => false
    case _ => if (isSame(s, t)) return true
      isSubtree(s.left, t) || isSubtree(s.right, t)
  }

  def isSame(s: TreeNode, t: TreeNode): Boolean = {
    if (s == null && t == null) return true
    if (s == null || t == null) return false
    if (s.value != t.value) return false
    isSame(s.left, t.left) && isSame(s.right, t.right)
  }
}
