package leetCode

object Solution_2351 {
  @scala.annotation.tailrec
  def f(seen: Set[Char], list: List[Char]): Option[Char] = list match {
    case Nil => None
    case c :: tail => if (seen.contains(c)) Some(c) else f(seen + c, tail)
  }

  def repeatedCharacter(s: String): Char =
    f(Set.empty, s.toList).get
}
