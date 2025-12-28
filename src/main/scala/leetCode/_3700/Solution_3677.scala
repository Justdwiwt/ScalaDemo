package leetCode._3700

object Solution_3677 {
  def countBinaryPalindromes(n: Long): Int = {
    if (n == 0) return 1

    val m = 64 - java.lang.Long.numberOfLeadingZeros(n)

    val smaller = (1 until m).foldLeft(1L)((a, i) => a + (1L << ((i - 1) / 2)))

    @scala.annotation.tailrec
    def prefix(i: Int, ans: Long): Long =
      if (i < m / 2) ans
      else {
        val add =
          if (((n >> i) & 1L) == 1L) 1L << (i - m / 2)
          else 0L
        prefix(i - 1, ans + add)
      }

    val base = prefix(m - 2, smaller)

    val palLeft = n >> (m / 2)
    val midShift = m % 2

    @scala.annotation.tailrec
    def build(v: Long, p: Long): Long =
      if (v == 0) p
      else build(v >> 1, (p << 1) | (v & 1))

    val pal = build(palLeft >> midShift, palLeft)
    (base + (if (pal <= n) 1 else 0)).toInt
  }
}
