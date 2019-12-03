package leetCode

import scala.collection.mutable

object Solution_107 {
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    if (root == null) return List.empty
    var res = List[List[Int]]()
    val q = new mutable.Queue[TreeNode]()
    q.enqueue(root)
    while (q.nonEmpty) {
      var level = List[Int]()
      (q.size until 0 by -1).foreach(_ => {
        val t = q.front
        q.dequeue
        level :+= t.value
        if (t.left != null) q.enqueue(t.left)
        if (t.right != null) q.enqueue(t.right)
      })
      res +:= level
    }
    res
  }
}
