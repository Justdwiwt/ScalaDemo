package leetCode._2800

import scala.collection.mutable

object Solution_2773 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }


  def heightOfTree(root: TreeNode): Int = {
    val queue = mutable.Queue.empty[TreeNode] += root
    var level = 0

    def f(node: TreeNode): Unit = {
      if (node.left != null && node.left.right != node) queue += node.left
      if (node.right != null && node.right.left != node) queue += node.right
    }

    Iterator
      .continually(queue)
      .takeWhile(_.nonEmpty)
      .foreach(_ => {
        val m = queue.size
        (0 until m).foreach(_ => f(queue.dequeue()))
        level += 1
      })

    level - 1
  }
}
