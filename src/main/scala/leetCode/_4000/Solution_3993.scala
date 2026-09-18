package leetCode._4000

object Solution_3993 {
  def maximumValue(n: Int, s: Int, m: Int): Long =
    if (n == 1) s
    else s.toLong + m + (m - 1L) * (n / 2 - 1)
}
