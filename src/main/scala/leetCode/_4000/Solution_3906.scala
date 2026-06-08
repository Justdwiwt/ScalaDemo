package leetCode._4000

object Solution_3906 {
  private def comb(n: Int, k: Int): BigInt =
    if (k < 0 || k > n) BigInt(0)
    else {
      val kk = math.min(k, n - k)
      (1 to kk).foldLeft(BigInt(1))((res, i) => res * (n - kk + i) / i)
    }

  def countGoodIntegersOnPath(l: Long, r: Long, directions: String): Long = {
    val rs = (r + 1).toString
    val n = rs.length
    val ls = l.toString.reverse.padTo(n, '0').reverse

    val inPath = Array.fill(n)(false)
    inPath(n - 1) = true

    directions
      .reverse
      .scanLeft(n - 1)((pos, d) => pos - (if (d == 'R') 1 else 4))
      .tail
      .takeWhile(_ >= 0)
      .foreach(inPath(_) = true)

    val suf = inPath.scanRight(0)((b, s) => s + (if (b) 1 else 0))

    def solve(limit: String): BigInt = limit
      .zipWithIndex
      .foldLeft((BigInt(0), 0, true)) {
        case ((res, pre, alive), (ch, i)) =>
          if (!alive) (res, pre, false)
          else {
            val hi = ch - '0'
            val m = suf(i + 1)

            if (!inPath(i)) (res + BigInt(hi) * comb(m + 9 - pre, m) * BigInt(10).pow(n - 1 - i - m), pre, true)
            else if (hi < pre) (res, pre, false)
            else (res + (comb(m + 10 - pre, m + 1) - comb(m + 10 - hi, m + 1)) * BigInt(10).pow(n - 1 - i - m), hi, true)
          }
      }._1

    (solve(rs) - solve(ls)).toLong
  }
}
