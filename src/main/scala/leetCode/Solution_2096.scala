package leetCode

object Solution_2096 {
  def getDirections(root: TreeNode, startValue: Int, destValue: Int): String = {

    def paths(root: TreeNode, path: List[TreeNode], target: Int): Either[Boolean, List[TreeNode]] = {
      if (root == null) return Left(false)
      if (root.value == target) return Right(root :: path)

      val p1 = paths(root.left, root :: path, target)
      val p2 = paths(root.right, root :: path, target)

      if (p1.isRight) p1
      else if (p2.isRight) p2
      else Left(false)
    }

    var path1 = paths(root, List.empty, startValue).getOrElse(List.empty).reverse
    var path2 = paths(root, List.empty, destValue).getOrElse(List.empty).reverse
    var op: Option[TreeNode] = None

    while (path1.nonEmpty && path2.nonEmpty && path2.head.value == path1.head.value) {
      op = Some(path2.head)
      path1 = path1.tail
      path2 = path2.tail
    }

    val sb = new collection.mutable.StringBuilder()

    while (path1.nonEmpty) {
      sb += 'U'
      path1 = path1.tail
    }
    while (path2.nonEmpty) {
      val head = path2.head
      if (op.get.left != null && op.get.left.value == head.value)
        sb += 'L'
      else sb += 'R'
      op = Some(head)
      path2 = path2.tail
    }

    sb.mkString
  }
}
