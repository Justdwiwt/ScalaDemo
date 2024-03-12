package leetCode._700

import leetCode.TreeNode

import scala.collection.mutable

object Solution_652 {
  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
    val m = mutable.HashMap.empty[String, Int].withDefaultValue(0)
    val diff = mutable.HashMap.empty[String, TreeNode]

    def f(root: TreeNode): String = {
      if (root != null) {
        val hashKey = f(root.left) + "," + f(root.right) + "," + root.value
        m(hashKey) += 1
        diff(hashKey) = root
        hashKey
      } else ""
    }

    f(root)
    diff.keySet.intersect(m.filter(_._2 > 1).keySet).map(diff(_)).toList
  }
}
