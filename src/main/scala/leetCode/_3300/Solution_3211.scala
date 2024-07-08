package leetCode._3300

object Solution_3211 {
  def validStrings(n: Int): List[String] =
    if (n <= 1) List("0", "1")
    else validStrings(n - 1).flatMap(s => List(s + "0", s + "1")).filter(!_.endsWith("00"))
}
