package leetCode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_652 {
  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
    val res = new ListBuffer[TreeNode]()
    val m = new mutable.HashMap[String, Int]()
    func(root, m, res)
    res.toList
  }

  def func(node: TreeNode, m: mutable.HashMap[String, Int], res: mutable.ListBuffer[TreeNode]): String = node match {
    case null => "#"
    case _ =>
      val str = node.value.toString + "," + func(node.left, m, res) + "," + func(node.right, m, res)
      if (m(str) == 1) res.append(node)
      m(str) += 1
      str
  }
}
