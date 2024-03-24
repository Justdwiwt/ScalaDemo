package leetCode._1700

object Solution_1680 {
  def concatenatedBinary(n: Int): Int = (1 to n)
    .foldLeft(0)((res, num) => num.toBinaryString.foldLeft(res)((res, d) => ((res << 1) + d - '0') % (1e9 + 7).toInt))
}
