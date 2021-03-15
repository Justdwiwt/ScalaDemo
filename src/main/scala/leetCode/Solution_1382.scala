package leetCode

object Solution_1382 {
  def balanceBST(root: TreeNode): TreeNode = {
    def inOrderTraversal(ndOpts: Option[TreeNode]): List[TreeNode] = ndOpts
      .map(nd => inOrderTraversal(Option(nd.left)) ::: nd :: inOrderTraversal(Option(nd.right)))
      .getOrElse(List.empty[TreeNode])

    def buildBalanceBST(nodeList: List[TreeNode], st: Int, en: Int): TreeNode =
      if (st >= en) null
      else {
        val mid = st + (en - st) / 2
        val nd = nodeList(mid)
        nd.left = buildBalanceBST(nodeList, st, mid)
        nd.right = buildBalanceBST(nodeList, mid + 1, en)
        nd
      }

    val nodeList = inOrderTraversal(Option(root))
    buildBalanceBST(nodeList, 0, nodeList.length)
  }
}
