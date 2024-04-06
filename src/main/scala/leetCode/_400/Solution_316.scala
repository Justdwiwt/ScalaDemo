package leetCode._400

object Solution_316 {
  def removeDuplicateLetters(s: String): String = {
    val map = s.iterator.zipWithIndex.toMap

    @scala.annotation.tailrec
    def f(i: Int, used: Set[Char], stack: List[Char]): String = {
      lazy val ch: Char = s(i)
      if (i >= s.length) stack.reverse.mkString
      else if (used.contains(ch)) f(i + 1, used, stack)
      else if (stack.headOption.exists(h => h > ch && map(h) > i)) f(i, used - stack.head, stack.tail)
      else f(i + 1, used + ch, ch +: stack)
    }

    f(0, Set(), Nil)
  }
}
