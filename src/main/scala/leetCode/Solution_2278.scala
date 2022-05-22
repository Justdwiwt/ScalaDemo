package leetCode

object Solution_2278 {
  def percentageLetter(s: String, letter: Char): Int = {
    val cnt = s.count(_ == letter)
    100 * cnt / s.length
  }
}
