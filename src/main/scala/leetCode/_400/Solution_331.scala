package leetCode._400

object Solution_331 {
  private sealed trait Path

  private case object Left extends Path

  private case object Right extends Path

  @scala.annotation.tailrec
  private def unwindRights(stack: List[Path]): List[Path] = stack match {
    case Right :: rest => unwindRights(rest)
    case _ => stack
  }

  def isValidSerialization(preorder: String): Boolean = {
    val nodes = preorder.split(",").toList
    val paths = List.empty[Path]

    verify(nodes, paths)
  }

  @scala.annotation.tailrec
  private def verify(nodes: List[String], paths: List[Path]): Boolean = nodes match {
    case Nil => false
    case "#" :: Nil => unwindRights(paths).isEmpty
    case "#" :: nodesTail =>
      paths match {
        case Left :: pathsTail => verify(nodesTail, Right :: pathsTail)
        case Right :: _ => verify(nodes, unwindRights(paths))
        case Nil => false
      }
    case _ :: nodesTail => verify(nodesTail, Left :: paths)
  }
}
