package leetCode

object Solution_1305 {
  def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] = {
    var res = List.empty[Int]

    def f(root: TreeNode): Unit = {
      if (root != null) {
        res :+= root.value
        f(root.left)
        f(root.right)
      }
    }

    f(root1)
    f(root2)
    res.sorted
  }
}
