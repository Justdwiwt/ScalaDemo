package leetCode

object Solution_2800 {
  def minimumString(a: String, b: String, c: String): String =
    List(a, b, c).permutations.map(f(_, Nil)).minBy(s => (s.length, s))

  @scala.annotation.tailrec
  private def f(strings: List[String], acc: List[Char]): String = strings match {
    case Nil => acc.mkString
    case s :: tail =>
      @scala.annotation.tailrec
      def g(check: List[Char], checked: List[Char]): List[Char] =
        if (s.startsWith(check)) checked.reverse ::: s.toList
        else g(check.tail, check.head :: checked)

      if (acc.containsSlice(s)) f(tail, acc) else f(tail, g(acc, Nil))
  }
}
