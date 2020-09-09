package leetCode

object Solution_865 {
  def subtreeWithAllDeepest(root: TreeNode): TreeNode = {
    f(root, 0).map(_._1).orNull
  }

  def f(node: TreeNode, depth: Int): Option[(TreeNode, Int)] = {
    if (node == null) Option.empty
    else {
      (f(node.left, depth + 1), f(node.right, depth + 1)) match {
        case (None, None) => Option((node, depth))
        case (lResult@Some(_), None) => lResult
        case (None, rResult@Some(_)) => rResult
        case (lResult@Some((_, lDepth)), rResult@Some((_, rDepth))) =>
          if (lDepth > rDepth) lResult
          else if (lDepth < rDepth) rResult
          else Option((node, lDepth))
      }
    }
  }
}
