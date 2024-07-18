package leetCode.crackingCodeInterview

import leetCode.TreeNode

import scala.collection.mutable.ListBuffer

object Code_04_09 {
  private var res: ListBuffer[ListBuffer[Int]] = _

  def BSTSequences(root: TreeNode): List[List[Int]] = {
    res = ListBuffer()
    val path: ListBuffer[Int] = ListBuffer()
    if (root == null) {
      res += path
      return res.map(_.toList).toList
    }
    val queue = ListBuffer(root)
    bfs(queue, path)
    res.map(_.toList).toList
  }

  private def bfs(_queue: ListBuffer[TreeNode], path: ListBuffer[Int]): Unit = {
    var queue = _queue
    if (queue.isEmpty) {
      res += path.clone()
      return
    }
    val copy = queue.clone()
    queue.indices.foreach(i => {
      val cur = queue(i)
      path += cur.value
      queue.remove(i)
      if (cur.left != null) queue += cur.left
      if (cur.right != null) queue += cur.right
      bfs(queue, path)
      path.remove(path.length - 1)
      queue = copy.clone()
    })
  }
}
