package leetCode._1500

import leetCode.TreeNode

object Solution_1469 {
  def getLonelyNodes(root: TreeNode): List[Int] =
    if (root == null || (root.left == null && root.right == null)) Nil
    else {
      val leftLonely = Option(root.left).filter(_ => root.right == null).map(_.value).toList
      val rightLonely = Option(root.right).filter(_ => root.left == null).map(_.value).toList

      val leftList = Option(root.left).toList.flatMap(getLonelyNodes)
      val rightList = Option(root.right).toList.flatMap(getLonelyNodes)

      leftLonely ++ rightLonely ++ leftList ++ rightList
    }
}
