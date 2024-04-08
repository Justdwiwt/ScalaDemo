package leetCode._200

import leetCode.TreeNode

object Solution_124 {
  def maxPathSum(root: TreeNode): Int = {
    def getMxValues(root: TreeNode): (Int, Int) = {
      val leftMx = if (root.left != null) Some(getMxValues(root.left)) else None
      val rightMx = if (root.right != null) Some(getMxValues(root.right)) else None

      val connectedMaximum = (
        Seq(root.value) ++
          leftMx.map(_._1 + root.value).toSeq ++
          rightMx.map(_._1 + root.value).toSeq
        ).max

      val localMaximum = (
        leftMx.map(v => Seq(v._1, v._2)).getOrElse(Seq.empty) ++
          rightMx.map(v => Seq(v._1, v._2)).getOrElse(Seq.empty) ++
          Seq(root.value) ++
          leftMx.map(_._1).flatMap(left => rightMx.map(_._1).map(left + _ + root.value)).toSeq
        ).max

      (connectedMaximum, localMaximum)
    }

    val (connectedMaximum, localMaximum) = getMxValues(root)
    connectedMaximum.max(localMaximum)
  }
}
