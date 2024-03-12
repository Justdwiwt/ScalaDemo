package leetCode._300

import scala.collection.mutable.ListBuffer

object Solution_272 {
  def closestKValues(root: TreeNode, target: Double, k: Int): List[Int] = {
    val cur = root
    val res = ListBuffer.empty[Int]
    inOrder(target, cur, res, k)
    res.toList
  }

  def inOrder(target: Double, cur: TreeNode, cache: ListBuffer[Int], k: Int): Unit = {
    if (null == cur) return
    inOrder(target, cur.left, cache, k)
    if (cache.size < k) cache += cur.value
    else if ((cache.head - target).abs - (cur.value - target).abs > 1e-6d) {
      cache.remove(0)
      cache += cur.value
    } else return
    inOrder(target, cur.right, cache, k)
  }
}
