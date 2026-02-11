package leetCode._3900

object Solution_3816 {
  def lexSmallestAfterDeletion(s: String): String = {

    val initLeft: Map[Char, Int] = s.groupBy(identity).mapValues(_.length)

    @scala.annotation.tailrec
    def popWhile(st: List[Char], left: Map[Char, Int], ch: Char): (List[Char], Map[Char, Int]) = st match {
      case top :: rest if ch < top && left(top) > 1 => popWhile(rest, left.updated(top, left(top) - 1), ch)
      case _ => (st, left)
    }

    val (stack, leftAfter) = s.foldLeft((List.empty[Char], initLeft)) {
      case ((st, left), ch) =>
        val (st2, left2) = popWhile(st, left, ch)
        (ch :: st2, left2)
    }

    @scala.annotation.tailrec
    def trim(st: List[Char], left: Map[Char, Int]): List[Char] = st match {
      case top :: rest if left(top) > 1 => trim(rest, left.updated(top, left(top) - 1))
      case _ => st
    }

    trim(stack, leftAfter).reverse.mkString
  }
}
