package leetCode.LCP

import leetCode.TreeNode

import scala.collection.mutable

object LCP_52 {
  def getNumber(root: TreeNode, ops: Array[Array[Int]]): Int = {
    val tree = mutable.TreeSet.empty[Int]
    buildTree(tree, root)
    val red = mutable.HashSet.empty[Int]

    ops.indices.reverse.foreach(i => {
      val color = ops(i).head
      val low = ops(i)(1)
      val high = ops(i)(2)

      val sub = tree.range(low, high + 1)

      sub.foreach(tmp => {
        if (color == 1) red.add(tmp)
        tree.remove(tmp)
      })
    })
    red.size
  }

  private def buildTree(tree: mutable.TreeSet[Int], root: TreeNode): Unit = {
    if (root == null) return
    buildTree(tree, root.left)
    tree.add(root.value)
    buildTree(tree, root.right)
  }
}
