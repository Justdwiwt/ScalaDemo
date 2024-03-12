package leetCode._300

import scala.collection.mutable

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

object Solution_226 {
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) return null
    val q = mutable.Queue[TreeNode]()
    q.enqueue(root)
    while (q.nonEmpty) {
      val current: TreeNode = q.front
      var tmp: TreeNode = null
      tmp = current.left
      current.left = current.right
      current.right = tmp
      q.dequeue()
      if (current.left != null) q.enqueue(current.left)
      if (current.right != null) q.enqueue(current.right)
    }
    root
  }
}
