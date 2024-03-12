package leetCode._1400

import leetCode.TreeNode

object Solution_1302 {
  case class LevelWithLeafSum(level: List[TreeNode], leafSum: Int)

  def deepestLeavesSum(root: TreeNode): Int =
    cal(LevelWithLeafSum(List(root), 0))

  @scala.annotation.tailrec
  def cal(tree: LevelWithLeafSum): Int =
    if (tree.level.isEmpty) tree.leafSum
    else {
      val next = tree.level./:(LevelWithLeafSum(List.empty[TreeNode], 0))((levelSum, node) => {
        if (isLeaf(node)) levelSum.copy(leafSum = levelSum.leafSum + node.value)
        else levelSum.copy(level = add(add(levelSum.level, Option(node.left)), Option(node.right)))
      })
      cal(next)
    }

  def add(list: List[TreeNode], opt: Option[TreeNode]): List[TreeNode] =
    opt./:(list)(_ :+ _)

  def isLeaf(node: TreeNode): Boolean =
    Option(node.left).isEmpty && Option(node.right).isEmpty
}
