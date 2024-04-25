package leetCode._3200

object Solution_3125 {
  def maxNumber(n: Long): Long =
    (1L << (n.toBinaryString.length - 1L)) - 1L
}
