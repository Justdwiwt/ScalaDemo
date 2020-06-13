package leetCode

import scala.collection.mutable

object Solution_1302 {
  def deepestLeavesSum(root: TreeNode): Int = root match {
    case null => 0
    case _ =>
      var res = 0
      val q = new mutable.Queue[TreeNode]()
      q.enqueue(root)
      while (q.nonEmpty) {
        res = 0
        val size = q.size
        (0 until size).foreach(_ => {
          val node = q.head
          q.dequeue()
          res += node.value
          if (node.left != null) q.enqueue(node.left)
          if (node.right != null) q.enqueue(node.right)
        })
      }
      res
  }
}
