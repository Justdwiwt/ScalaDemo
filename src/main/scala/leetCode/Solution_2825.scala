package leetCode

object Solution_2825 {
  def canMakeSubsequence(str1: String, str2: String): Boolean =
    f(str1.toList, str2.toList)

  @scala.annotation.tailrec
  private def f(chars: List[Char], pattern: List[Char]): Boolean = (chars, pattern) match {
    case (_, Nil) => true
    case (Nil, _) => false
    case (c :: cTail, p :: pTail) => if (c == p || cycle(c) == p) f(cTail, pTail) else f(cTail, pattern)
  }

  private def cycle(c: Char): Char =
    if (c == 'z') 'a' else (c + 1).toChar
}
