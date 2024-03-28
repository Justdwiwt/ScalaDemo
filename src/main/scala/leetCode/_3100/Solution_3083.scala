package leetCode._3100

object Solution_3083 {
  def isSubstringPresent(s: String): Boolean = s
    .sliding(2, 1)
    .exists(v => v.length() == 2 && s.contains(v.reverse))
}
