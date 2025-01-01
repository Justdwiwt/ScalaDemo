package leetCode._2800

object Solution_2792 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def countGreatEnoughNodes(root: TreeNode, k: Int): Int = {
    var res = 0

    def dfs(node: Option[TreeNode]): List[Int] = node match {
      case Some(n) =>
        val leftList = dfs(Option(n.left))
        val rightList = dfs(Option(n.right))
        val sortedList = (leftList ++ rightList :+ n.value).sorted.take(k)
        if (sortedList.last < n.value) res += 1
        sortedList
      case None => List.empty
    }

    dfs(Option(root))
    res
  }
}
