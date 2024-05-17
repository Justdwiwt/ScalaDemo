package leetCode.LCP

import scala.collection.mutable

// fixme: case 67/70 stack overflow
object LCP_64 {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  def closeLampInTree(root: TreeNode): Int = {
    val memo = mutable.Map[(TreeNode, Boolean, Boolean), Int]()

    def f(node: TreeNode, switch2: Boolean, switch3: Boolean): Int = {
      if (node == null) return 0
      if (memo.contains((node, switch2, switch3))) return memo((node, switch2, switch3))

      val isLampOn = (node.value == 1) == (switch2 == switch3)
      val res = if (isLampOn) {
        val res1 = f(node.left, switch2, switch3 = false) + f(node.right, switch2, switch3 = false) + 1
        val res2 = f(node.left, !switch2, switch3 = false) + f(node.right, !switch2, switch3 = false) + 1
        val res3 = f(node.left, switch2, switch3 = true) + f(node.right, switch2, switch3 = true) + 1
        val res123 = f(node.left, !switch2, switch3 = true) + f(node.right, !switch2, switch3 = true) + 3
        res1.min(res2).min(res3.min(res123))
      } else {
        val res0 = f(node.left, switch2, switch3 = false) + f(node.right, switch2, switch3 = false)
        val res12 = f(node.left, !switch2, switch3 = false) + f(node.right, !switch2, switch3 = false) + 2
        val res13 = f(node.left, switch2, switch3 = true) + f(node.right, switch2, switch3 = true) + 2
        val res23 = f(node.left, !switch2, switch3 = true) + f(node.right, !switch2, switch3 = true) + 2
        res0.min(res12).min(res13.min(res23))
      }

      memo((node, switch2, switch3)) = res
      res
    }

    f(root, switch2 = false, switch3 = false)
  }
}
