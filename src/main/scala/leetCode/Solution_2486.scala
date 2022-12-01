package leetCode

object Solution_2486 {
  def appendCharacters(s: String, t: String): Int = {
    @scala.annotation.tailrec
    def f(s: List[Char], t: List[Char]): Int = (s, t) match {
      case (Nil, _) => t.size
      case (_, Nil) => 0
      case (x :: xs, y :: ys) => if (x == y) f(xs, ys) else f(xs, t)
    }

    f(s.toList, t.toList)
  }
}
