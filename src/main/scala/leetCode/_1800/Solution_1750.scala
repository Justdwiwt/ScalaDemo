package leetCode._1800

object Solution_1750 {
  def minimumLength(s: String): Int = {
    @scala.annotation.tailrec
    def f(start: Int, end: Int): Int =
      if (start == end) 0
      else {
        (end - 1 until start by (-1)).takeWhile(s(_) == s(start)).size match {
          case 0 => end - start
          case n => f((start + 1 until end - n).find(s(_) != s(start)).getOrElse(end - n), end - n)
        }
      }

    f(0, s.length)
  }
}
