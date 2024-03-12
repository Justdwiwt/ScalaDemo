package leetCode._3000

object Solution_2914 {
  def minChanges(s: String): Int = {
    @scala.annotation.tailrec
    def f(chars: List[Char], acc: Int): Int = chars match {
      case c1 :: c2 :: cs => if (c1 == c2) f(cs, acc) else f(cs, acc + 1)
      case _ => acc
    }

    f(s.toList, 0)
  }
}
