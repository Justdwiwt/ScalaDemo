package leetCode._3500

object Solution_3438 {
  def findValidPair(s: String): String = {
    val cnt = s.groupBy(identity).mapValues(_.length)
    s
      .zip(s.tail)
      .collectFirst { case (x, y) if x != y && cnt(x) == x.asDigit && cnt(y) == y.asDigit => s"$x$y" }
      .getOrElse("")
  }
}
