package leetCode._2900

object Solution_2864 {
  def maximumOddBinaryNumber(s: String): String = {
    val ones = s.count(_ == '1')
    "1" * (ones - 1) + "0" * (s.length() - ones) + "1"
  }
}
