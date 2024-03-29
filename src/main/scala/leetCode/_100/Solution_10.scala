package leetCode._100

object Solution_10 {
  def isMatch(S: Seq[Char], P: Seq[Char]): Boolean = {
    if (P.isEmpty) return S.isEmpty
    val Seq(p, t@_*) = P
    val same = S.headOption.exists(_ == p || p == '.')
    t.headOption.filter(_ == '*') match {
      case Some(_) => isMatch(S, P.drop(2)) || (same && isMatch(S.drop(1), P))
      case None => same && isMatch(S.drop(1), P.drop(1))
    }
  }
}
