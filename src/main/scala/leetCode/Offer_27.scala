package leetCode

import scala.collection.mutable

object Offer_27 {
  def mirrorTree(root: TreeNode): TreeNode = {
    if (root == null) return null
    val q = mutable.Queue[TreeNode]()
    q.enqueue(root)
    while (q.nonEmpty) {
      val cur = q.front
      val tmp = cur.left
      cur.left = cur.right
      cur.right = tmp
      q.dequeue()
      if (cur.left != null) q.enqueue(cur.left)
      if (cur.right != null) q.enqueue(cur.right)
    }
    root
  }
}
