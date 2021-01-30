package leetCode

object Solution_662 {
  def widthOfBinaryTree(root: TreeNode): Int = {
    def f(seq: Seq[(TreeNode, Int)]): Int =
      if (seq.isEmpty) 0
      else (seq.last._2 - seq.head._2).max(
        f(seq./:(Seq.empty[(TreeNode, Int)])((res, node) => {
          val tmp = Option(node._1.left).map(res :+ (_, node._2 * 2)).getOrElse(res)
          Option(node._1.right).map(tmp :+ (_, node._2 * 2 + 1)).getOrElse(tmp)
        }))
      )

    f(Seq((root, 1))) + 1
  }
}
