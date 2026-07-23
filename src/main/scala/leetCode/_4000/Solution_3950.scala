package leetCode._4000

object Solution_3950 {
  def consecutiveSetBits(n: Int): Boolean = n
    .toBinaryString
    .zip(n.toBinaryString.drop(1))
    .count(n => n._2 + n._1 - '0' - '0' == 2) == 1
}
