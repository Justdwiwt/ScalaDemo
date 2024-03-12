package leetCode._1600

object Solution_1573 {
  def numWays(s: String): Int = {
    val ones = s.count(n => n == '1')
    val n = s.length
    if (ones == 0) return ((n - 2L) * (n - 1L) / 2 % 1000000007).toInt
    if (ones % 3 != 0) return 0
    val t = ones / 3
    val c = s.indices./:(0L, 0L, 0)((b, a) => {
      val cnt = b._3 + s.charAt(a) - '0'
      if (cnt == t) (b._1 + 1, b._2, cnt)
      else if (cnt == 2 * t) (b._1, b._2 + 1, cnt)
      else (b._1, b._2, cnt)
    })
    (c._1 * c._2 % 1000000007).toInt
  }
}
