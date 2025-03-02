package leetCode._3500

object Solution_3461 {
  def hasSameDigits(s: String): Boolean = Stream
    .iterate(s)(cur => cur
      .sliding(2)
      .map(pair => ((pair.head.asDigit + pair(1).asDigit) % 10).toString)
      .mkString)
    .dropWhile(_.length > 2)
    .head
    .distinct
    .length == 1
}
