package leetCode

object Solution_524 {
  def findLongestWord(s: String, d: List[String]): String = {
    d.filter(x => x.length <= s.length && check(s, x, 0, 0)) match {
      case Nil => ""
      case x => x.minBy(x => (-x.length, x))
    }
  }

  @scala.annotation.tailrec
  def check(s1: String, s2: String, i1: Int, i2: Int): Boolean =
    if (i2 == s2.length) true
    else if (i1 == s1.length) false
    else if (s1(i1) == s2(i2)) check(s1, s2, i1 + 1, i2 + 1)
    else check(s1, s2, i1 + 1, i2)
}
