package leetCode

object Solution_337 {
  def rob(root: TreeNode): Int = {
    def f(node: TreeNode): (Int, Int) =
      if (node == null) (0, 0)
      else (f(node.left), f(node.right)) match {
        case ((leftRobbed, leftSkipped), (rightRobbed, rightSkipped)) =>
          (node.value + leftSkipped + rightSkipped, leftRobbed.max(leftSkipped) + rightRobbed.max(rightSkipped))
      }

    f(root) match {
      case (rootRobed, rootSkipped) => rootRobed.max(rootSkipped)
    }
  }
}
