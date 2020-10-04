package leetCode

import scala.collection.mutable

object Solution_1261 {

  class FindElements(_root: TreeNode) {

    val s = mutable.Set.empty[Int]

    def recover(root: TreeNode): TreeNode = {
      if (root == null) return null
      else {
        s.add(root.value)
        if (root.left != null) {
          root.left.value = root.value * 2 + 1
          recover(root.left)
        }
        if (root.right != null) {
          root.right.value = root.value * 2 + 2
          recover(root.right)
        }
      }
      root
    }

    def addChildren(node: TreeNode, list: List[TreeNode]): List[TreeNode] = {
      List(node.left, node.right).foldLeft(list) {
        (acc, child) => if (child != null) acc :+ child else acc
      }
    }

    _root.value = 0

    val recovered: TreeNode = recover(_root)

    def find(target: Int): Boolean = s.contains(target)

  }

}
