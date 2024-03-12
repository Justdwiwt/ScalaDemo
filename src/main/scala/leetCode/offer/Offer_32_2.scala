package leetCode.offer

import leetCode.TreeNode

import scala.collection.mutable

object Offer_32_2 {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    var res = List.empty[List[Int]]
    if (root == null) return res
    val q = new mutable.Queue[TreeNode]()
    var p: TreeNode = null
    q.enqueue(root)
    while (q.nonEmpty) {
      var t = List.empty[Int]
      q.indices.foreach(_ => {
        p = q.front
        t :+= p.value
        q.dequeue()
        if (p.left != null) q.enqueue(p.left)
        if (p.right != null) q.enqueue(p.right)
      })
      res :+= t
    }
    res
  }
}
