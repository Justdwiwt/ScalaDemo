package leetCode._1000

import leetCode.TreeNode

object Solution_958 {
  def isCompleteTree(root: TreeNode): Boolean = {
    var q = List[TreeNode]()
    q = root :: q
    while (q.nonEmpty) {
      q.head match {
        case null => return q.tail.forall(_ == null)
        case _ => q = q.tail ::: List(q.head.left, q.head.right)
      }
    }
    true
  }
}
