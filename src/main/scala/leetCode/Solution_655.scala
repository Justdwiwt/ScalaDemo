package leetCode

object Solution_655 {
  def printTree(root: TreeNode): List[List[String]] = {
    def getHeight(node: TreeNode): Int =
      if (node == null) 0
      else 1 + math.max(getHeight(node.left), getHeight(node.right))

    val h = getHeight(root)
    val res = (1 to h).map(_ => (1 until math.pow(2, h).toInt).map(_ => "").toArray).toList

    def f(node: TreeNode, level: Int, pos: Int, move: Int): Unit = {
      if (node != null) {
        res(level)(pos) = node.value.toString
        f(node.left, level + 1, pos - move, move / 2)
        f(node.right, level + 1, pos + move, move / 2)
      }
    }

    f(root, 0, math.pow(2, h - 1).toInt - 1, math.pow(2, h - 2).toInt)

    res.map(_.toList)
  }
}
