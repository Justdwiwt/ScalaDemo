package leetCode._2300

object Solution_2278 {
  def percentageLetter(s: String, letter: Char): Int = {
    s.count(_ == letter) * 100 / s.length
  }
}
