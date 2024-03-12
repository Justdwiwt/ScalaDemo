package leetCode.offer

import leetCode.TreeNode

import scala.collection.mutable

object Offer_32_3 {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    var res = List.empty[List[Int]]
    if (root == null) return res
    val q = new mutable.Queue[TreeNode]()
    q.enqueue(root)
    var v = List.empty[Int]
    var cnt = 0
    while (q.nonEmpty) {
      cnt += 1
      v = List.empty
      q.indices.foreach(_ => {
        val t = q.front
        q.dequeue()
        v :+= t.value
        if (t.left != null) q.enqueue(t.left)
        if (t.right != null) q.enqueue(t.right)
      })
      if (!((cnt & 1) > 0)) v = v.reverse
      if (v.nonEmpty) res :+= v
    }
    res
  }
}
