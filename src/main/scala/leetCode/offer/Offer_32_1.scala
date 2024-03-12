package leetCode.offer

import leetCode.TreeNode

import scala.collection.mutable

object Offer_32_1 {
  def levelOrder(root: TreeNode): Array[Int] = {
    var res = Array.empty[Int]
    if (root == null) return res
    val q = new mutable.Queue[TreeNode]()
    q.enqueue(root)
    while (q.nonEmpty) {
      val cur = q.front
      q.dequeue()
      res :+= cur.value
      if (cur.left != null) q.enqueue(cur.left)
      if (cur.right != null) q.enqueue(cur.right)
    }
    res
  }
}
