package leetCode._1200

import leetCode.TreeNode

object Solution_1161 {
  def maxLevelSum(root: TreeNode): Int = {
    require(root != null)
    Stream
      .iterate(Seq(root))(_.flatMap(node => Seq(Option(node.left), Option(node.right)).flatten))
      .takeWhile(_.nonEmpty)
      .map(_.map(_.value).sum)
      .zipWithIndex
      .maxBy(_._1)
      ._2 + 1
  }
}
