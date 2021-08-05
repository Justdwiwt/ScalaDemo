package leetCode

object Solution_1931 {
  def colorTheGrid(m: Int, n: Int): Int = {
    val M = (math.pow(10, 9) + 7).toLong

    val dp = Array.fill(n, 1 << (m << 1))(-1)

    def f(r: Int, c: Int, curRow: Int, preRow: Int): Int =
      if (r == n) 1
      else if (c == m) f(r + 1, 0, 0, curRow)
      else if (c == 0 && dp(r)(preRow) >= 0) dp(r)(preRow)
      else {
        val leftCell = if (c == 0) 0 else (curRow >> ((c - 1) << 1)) & 3
        val topCell = (preRow >> (c << 1)) & 3
        var cnt = 0L
        (1 to 3)
          .withFilter(cell => cell != leftCell && cell != topCell)
          .foreach(cell => cnt += f(r, c + 1, curRow | (cell << (c << 1)), preRow))
        cnt %= M
        dp(r)(preRow) = cnt.toInt
        dp(r)(preRow)
      }

    f(0, 0, 0, 0)
  }
}
