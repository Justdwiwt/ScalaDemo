package leetCode._1500

object Solution_1448 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def goodNodes(root: TreeNode): Int = {

    def cnt(ndOpts: Option[TreeNode], max: Int): Int = ndOpts
      .map(nd => {
        val curr = if (nd.value >= max) 1 else 0
        curr + cnt(Option(nd.left), max.max(nd.value)) + cnt(Option(nd.right), max.max(nd.value))
      })
      .getOrElse(0)

    cnt(Option(root), root.value)
  }
}
