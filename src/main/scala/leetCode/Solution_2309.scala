package leetCode

object Solution_2309 {
  def greatestLetter(s: String): String = ('Z'.toInt to 'A'.toInt by -1)
    .map(_.toChar)
    .find(c => s.contains(c) && s.contains(c.toLower))
    .map(_.toString)
    .getOrElse("")
}
