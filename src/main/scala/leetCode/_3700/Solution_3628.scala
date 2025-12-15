package leetCode._3700

object Solution_3628 {
  def numOfSubsequences(s: String): Long = {
    val totalT = s.count(_ == 'T').toLong

    val (l, c, t, lc, ct, lct, lt) =
      s.foldLeft((0L, 0L, totalT, 0L, 0L, 0L, 0L)) {
        case ((l, c, t, lc, ct, lct, lt), 'L') =>
          (l + 1, c, t, lc, ct, lct, lt.max((l + 1) * t))

        case ((l, c, t, lc, ct, lct, lt), 'C') =>
          (l, c + 1, t, lc + l, ct, lct, lt)

        case ((l, c, t, lc, ct, lct, lt), 'T') =>
          (l, c, t - 1, lc, ct + c, lct + lc, lt)

        case (state, _) => state
      }

    lct + ct.max(lc).max(lt)
  }
}
