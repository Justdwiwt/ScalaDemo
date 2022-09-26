package leetCode

object Solution_2414 {
  def longestContinuousSubstring(s: String): Int = s
    ./:((0, 1, 'z')) { case ((mx, cur, prev), c) =>
      if (c - prev == 1) (mx.max(cur + 1), cur + 1, c)
      else (mx.max(cur), 1, c)
    }
    ._1
}
