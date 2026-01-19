package leetCode._3800

object Solution_3750 {
  def minimumFlips(n: Int): Int = n
    .toBinaryString
    .zip(n.toBinaryString.reverse)
    .count(n => n._2 != n._1)
}
