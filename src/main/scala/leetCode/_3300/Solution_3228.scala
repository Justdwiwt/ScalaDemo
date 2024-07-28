package leetCode._3300

object Solution_3228 {
  def maxOperations(s: String): Int =
    s.zipWithIndex.foldLeft((0, 0)) { case ((ans, cnt1), (c, i)) =>
      if (c == '1') (ans, cnt1 + 1)
      else if (i > 0 && s(i - 1) == '1') (ans + cnt1, cnt1)
      else (ans, cnt1)
    }._1
}
