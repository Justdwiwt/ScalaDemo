package leetCode._400

import leetCode.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_314 {
  def verticalOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return Nil
    var res = List.empty[List[Int]]
    val m = mutable.HashMap.empty[Int, ArrayBuffer[Int]]
    var q = List.empty[(TreeNode, Int)]
    q ::= (root, 0)
    while (q.nonEmpty) {
      val cur = q.head._1
      val level = q.head._2
      m.getOrElseUpdate(level, ArrayBuffer.empty) += cur.value
      q = q.tail
      if (cur.left != null) q ::= (cur.left, level - 1)
      if (cur.right != null) q ::= (cur.right, level + 1)
    }
    m.foreach(res ::= _._2.toList)
    res
  }
}
