package leetCode

object Solution_113 {
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    if (root == null) Nil
    else if (root.value == sum && (root.left, root.right) == (null, null)) List(List(root.value))
    else (pathSum(root.left, sum - root.value) ++ pathSum(root.right, sum - root.value)).map(path => root.value :: path)
  }
}
