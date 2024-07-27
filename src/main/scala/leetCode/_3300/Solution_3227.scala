package leetCode._3300

object Solution_3227 {
  def doesAliceWin(s: String): Boolean =
    s.exists("aeiou".contains(_))
}
