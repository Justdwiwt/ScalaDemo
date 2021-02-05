package leetCode

object Solution_202 {
  def isHappy(n: Int): Boolean = {
    @scala.annotation.tailrec
    def f(x: Int, seen: Set[Int]): Boolean =
      if (seen.contains(x)) x == 1
      else f(x.toString.map(x => math.pow(x.asDigit, 2).toInt).sum, seen + x)

    f(n, Set.empty)
  }
}
