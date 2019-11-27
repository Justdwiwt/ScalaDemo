package leetCode

object Solution_551 {
  def checkRecord(s: String): Boolean = (s.indexOf("A") == s.lastIndexOf("A")) && !s.contains("LLL")
}
