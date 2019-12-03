package leetCode

import scala.collection.mutable

object Solution_1161 {
  def maxLevelSum(root: TreeNode): Int = {
    if (root == null) return 0
    var level = 1
    var mn = 1
    var mSum = 0
    val q = new mutable.Queue[TreeNode]()
    q.enqueue(root)
    while (q.nonEmpty) {
      var sum = 0
      q.indices.foreach(_ => {
        val node = q.front
        q.dequeue
        if (node.left != null) q.enqueue(node.left)
        if (node.right != null) q.enqueue(node.right)
        sum += node.value
      })
      if (sum > mSum) {
        mSum = sum
        mn = level
      }
      level += 1
    }
    mn
  }
}
