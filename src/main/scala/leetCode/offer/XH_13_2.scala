package leetCode.offer

import leetCode.TreeNode

import scala.collection.mutable

object XH_13_2 {
  def transferHeapToList(root: TreeNode): Array[Int] = {
    var res = Array.emptyIntArray
    if (root == null) return res
    val q = new mutable.Queue[TreeNode]()
    var p: TreeNode = null
    q.enqueue(root)
    while (q.nonEmpty) {
      q.indices.foreach(_ => {
        p = q.front
        res :+= p.value
        q.dequeue()
        if (p.left != null) q.enqueue(p.left)
        if (p.right != null) q.enqueue(p.right)
      })
    }
    res
  }
}
