package leetCode.offer

import leetCode.TreeNode

object Offer_047 {
  def pruneTree(root: TreeNode): TreeNode = {
    def f(opts: Option[TreeNode]): Option[TreeNode] = opts match {
      case None => None
      case Some(nd) =>
        val l = f(Option(nd.left))
        val r = f(Option(nd.right))
        if (l.isEmpty) nd.left = null
        if (r.isEmpty) nd.right = null
        if (l.isEmpty && r.isEmpty && nd.value == 0) None else Some(nd)
    }

    f(Option(root)).orNull
  }
}
