package leetCode._3200

object Solution_3174 {
  def clearDigits(s: String): String =
    f(List.empty, s.toList).mkString

  @scala.annotation.tailrec
  private def f(prev: List[Char], chars: List[Char]): List[Char] = chars match {
    case Nil => prev.reverse
    case h :: tail => if (h.isDigit) f(prev.drop(1), tail) else f(h :: prev, tail)
  }
}
