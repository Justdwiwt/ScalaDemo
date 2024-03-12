package leetCode._1000

import leetCode.TreeNode

import java.util

object Solution_919 {
  class CBTInserter(_root: TreeNode) {
    private val arr = new util.LinkedList[TreeNode]()
    private val q = new util.LinkedList[TreeNode]()
    q.add(_root)
    while (!q.isEmpty) {
      val t = q.remove()
      if (t.left != null) q.add(t.left)
      if (t.right != null) q.add(t.right)
      arr.add(t)
    }

    def insert(v: Int): Int = {
      val node = new TreeNode(v)
      arr.add(node)
      val p = arr.get(arr.size() / 2 - 1)
      if (p.left == null) p.left = node
      else p.right = node
      p.value
    }

    def get_root(): TreeNode = {
      arr.get(0)
    }

  }
}
