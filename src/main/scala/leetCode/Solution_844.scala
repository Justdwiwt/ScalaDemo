package leetCode

object Solution_844 {
  def backspaceCompare(S: String, T: String): Boolean = {
    @scala.annotation.tailrec
    def f(s: String, acc: List[Char]): String = {
      if (s.isEmpty) acc.toString.reverse
      else if (s.head == '#')
        if (acc.nonEmpty) f(s.tail, acc.tail)
        else f(s.tail, acc)
      else f(s.tail, s.head :: acc)
    }

    f(S, Nil) == f(T, Nil)
  }
}
