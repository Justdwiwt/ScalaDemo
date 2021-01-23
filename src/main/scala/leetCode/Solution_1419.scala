package leetCode

object Solution_1419 {
  def minNumberOfFrogs(croakOfFrogs: String): Int = {
    @scala.annotation.tailrec
    def f(c: Int, r: Int, o: Int, a: Int, min: Int, t: List[Char]): Int = t match {
      case Nil if c == 0 & r == 0 & o == 0 && a == 0 => min
      case Nil => -1
      case 'c' :: tail => f(c + 1, r, o, a, min.max(c + 1 + r + o + a), tail)
      case 'r' :: _ if c == 0 => -1
      case 'r' :: tail => f(c - 1, r + 1, o, a, min, tail)
      case 'o' :: _ if r == 0 => -1
      case 'o' :: tail => f(c, r - 1, o + 1, a, min, tail)
      case 'a' :: _ if o == 0 => -1
      case 'a' :: tail => f(c, r, o - 1, a + 1, min, tail)
      case 'k' :: _ if a == 0 => -1
      case 'k' :: tail => f(c, r, o, a - 1, min, tail)
    }

    f(0, 0, 0, 0, 0, croakOfFrogs.toList)
  }
}
