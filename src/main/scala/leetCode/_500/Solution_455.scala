package leetCode._500

object Solution_455 {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = s.sorted./:((0, g.sorted.toList)) {
    case (res@(content, children), cookie) => children
      .headOption
      .filter(_ <= cookie)
      .map(_ => (content + 1, children.tail))
      .getOrElse(res)
  }._1
}
