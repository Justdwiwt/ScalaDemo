package leetCode._700

object Solution_678 {
  def checkValidString(s: String): Boolean = {
    @scala.annotation.tailrec
    def f(s: List[Char], balanceMin: Int, balanceMax: Int): Boolean =
      if (balanceMax < 0) false
      else s match {
        case Nil => balanceMin == 0
        case '(' :: tail => f(tail, balanceMin + 1, balanceMax + 1)
        case ')' :: tail => f(tail, 0.max(balanceMin - 1), balanceMax - 1)
        case _ :: tail => f(tail, 0.max(balanceMin - 1), balanceMax + 1)
      }

    f(s.toList, 0, 0)
  }
}
