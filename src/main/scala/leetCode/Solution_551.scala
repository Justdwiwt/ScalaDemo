package leetCode

object Solution_551 {
  def checkRecord(s: String): Boolean =
    s.count(_ == 'A') <= 1 && !s.contains("LLL")
}
