package leetCode

object Solution_1859 {
  def sortSentence(s: String): String = s
    .split(' ')
    .map(_.reverse)
    .sorted
    .map(_.reverse)
    .map(_.dropRight(1))
    .mkString(" ")
}
