package leetCode

object Solution_894 {
  def allPossibleFBT(N: Int): List[TreeNode] = {
    def f(n: Int, m: Map[Int, List[TreeNode]]): Map[Int, List[TreeNode]] = {
      val newList = if (n % 2 == 0) List.empty[TreeNode]
      else (1 until n by 2)./:(List.empty[TreeNode])((res, num) => {
        val tmp = m(num).flatMap(left => m(n - 1 - num).map(right => {
          val node = new TreeNode(0)
          node.left = left
          node.right = right
          node
        }))
        tmp ::: res
      })
      m + (n -> newList)
    }

    (3 to N by 2)./:(Map(1 -> List(new TreeNode(0))))((prev, num) => f(num, prev)).getOrElse(N, List.empty[TreeNode])
  }
}
