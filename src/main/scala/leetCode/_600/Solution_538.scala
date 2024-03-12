package leetCode._600

import leetCode.TreeNode

object Solution_538 {
  def convertBST(root: TreeNode): TreeNode = {
    var sum = 0

    def f(root: TreeNode): Unit = root match {
      case null => ()
      case r =>
        f(r.right)
        r.value += sum
        sum = r.value
        f(r.left)
    }

    f(root)
    root
  }
}
