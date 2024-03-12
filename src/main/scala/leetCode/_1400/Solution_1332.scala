package leetCode._1400

object Solution_1332 {
  def removePalindromeSub(s: String): Int = s match {
    case s if s.isEmpty => 0
    case s if s == s.reverse => 1
    case _ => 2
  }
}
