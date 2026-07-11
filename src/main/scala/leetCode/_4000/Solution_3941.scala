package leetCode._4000

object Solution_3941 {
  def passwordStrength(password: String): Int = password
    .toSet
    .toList
    .map((p: Char) => if (p.isDigit) 3 else if (p.isLower) 1 else if (p.isUpper) 2 else 5)
    .sum
}
