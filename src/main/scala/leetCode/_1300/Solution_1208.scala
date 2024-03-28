package leetCode._1300

object Solution_1208 {
  def equalSubstring(s: String, t: String, maxCost: Int): Int = {
    lazy val diff = s.zip(t).map { case (a, b) => (a - b).abs }

    @scala.annotation.tailrec
    def f(lo: Int, hi: Int, budget: Int, currLen: Int, maxLen: Int): Int = {
      lazy val (dlo, dhi) = (diff(lo), diff(hi))
      if ((lo max hi) >= diff.size) maxLen
      else if (dhi > maxCost) f(hi + 1, hi + 1, maxCost, 0, maxLen)
      else if (dhi <= budget) f(lo, hi + 1, budget - dhi, currLen + 1, (currLen + 1) max maxLen)
      else f(lo + 1, hi, budget + dlo, currLen - 1, maxLen)
    }

    f(0, 0, maxCost, 0, 0)
  }
}
