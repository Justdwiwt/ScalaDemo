package leetCode._3200

class TreeNode(var value: Int = 0, var left: TreeNode = null, var right: TreeNode = null)

import scala.collection.mutable

object Solution_3157 {
  def minimumLevel(root: TreeNode): Int = {
    val map = mutable.Map[Long, Long]().withDefaultValue(0L)

    case class NodeDepth(node: TreeNode, depth: Int)

    val st = mutable.Stack[NodeDepth]()

    st.push(NodeDepth(root, 1))

    while (st.nonEmpty) {
      val current = st.pop()
      val node = current.node
      val depth = current.depth

      map(depth) += node.value
      if (node.left != null) st.push(NodeDepth(node.left, depth + 1))
      if (node.right != null) st.push(NodeDepth(node.right, depth + 1))
    }

    val minSum = map.values.min
    map.find { case (_, v) => v == minSum }.map(_._1).getOrElse(0L).toInt
  }
}
