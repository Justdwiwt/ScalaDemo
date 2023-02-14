package leetCode

object Solution_2565 {
  //  def minimumScore(s: String, t: String): Int = {
  //    val leftMatch = s.scanLeft(0, t.zipWithIndex) {
  //      case ((_, (ct, i) +: ts), cs) => if (ct == cs) (i, ts) else (-1, (ct, i) +: ts)
  //      case _ => (-1, null)
  //    }.map(_._1).drop(1)
  //    val lastMatch = leftMatch.findLast(_ != -1).getOrElse(-1)
  //    val lastUnmatch = (t.size - lastMatch - 1)
  //    val res = s.zip(leftMatch).reverse.scanLeft(lastUnmatch, lastMatch, t.zipWithIndex.reverse) {
  //      case ((_, m, (ct, i) +: ts), (cs, j)) =>
  //        val nm = if (j == -1) m else j - 1
  //        if (ct == cs) (i - nm - 1, nm, ts) else (Int.MaxValue, nm, (ct, i) +: ts)
  //      case _ => (0, 0, null)
  //    }
  //    res.map(_._1).min.max(0)
  //  }
}
