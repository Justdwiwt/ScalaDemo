package leetCode._3100

object Solution_3039 {
  def lastNonEmptyString(s: String): String = {
    val cnt = s.groupBy(identity).values
    cnt
      .filter(_.length == cnt.map(_.length).max)
      .map(_.head)
      .map(c => (s.lastIndexOf(c), c))
      .toSeq
      .sorted
      .map(_._2)
      .mkString
  }
}
