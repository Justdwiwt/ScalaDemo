package leetCode

object Solution_125 {
  def isPalindrome(s: String): Boolean = {
    if (s == null) return true
    val up = s.toUpperCase.filter(x => (x.toInt >= 65 && x.toInt <= 90)
      || (x.toInt >= 48 && x.toInt <= 57))
    !up.zip(up.reverse).exists(x => x._1 != x._2)
  }
}
