package leetCode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_103 {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return List.empty
    var flag = true
    var res = List[List[Int]]()
    val q = new mutable.Queue[TreeNode]()
    q.enqueue(root)
    while (q.nonEmpty) {
      val size = q.size
      val out = ListBuffer.fill(size)(0)
      q.indices.foreach(i => {
        val t = q.front
        q.dequeue
        val index = if (flag) i else size - 1 - i
        out(index) = t.value
        if (t.left != null) q.enqueue(t.left)
        if (t.right != null) q.enqueue(t.right)
      })
      flag = !flag
      res :+= out.toList
    }
    res
  }
}
