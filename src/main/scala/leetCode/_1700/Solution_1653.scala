package leetCode._1700

object Solution_1653 {
  def minimumDeletions(s: String): Int = {
    @scala.annotation.tailrec
    def f(s: List[Char], a: Int, b: Int, r: Int): Int = s match {
      case Nil => r.min(b)
      case c :: tail if c == 'b' => f(tail, a, b + 1, r.min(a + b))
      case _ :: tail => f(tail, a - 1, b, r)
    }

    f(s.toList, s.count(_ == 'a'), 0, Int.MaxValue)
  }
}
