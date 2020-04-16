package leetCode

import scala.collection.mutable

object Offer_54 {
  private val pq = new mutable.PriorityQueue[Int]()

  def kthLargest(root: TreeNode, k: Int): Int = {
    dfs(root)
    var t = k - 1
    while (t > 0) {
      pq.dequeue()
      t -= 1
    }
    pq.head
  }

  def dfs(root: TreeNode): Unit = {
    pq.enqueue(root.value)
    if (root.left != null) dfs(root.left)
    if (root.right != null) dfs(root.right)
  }
}
