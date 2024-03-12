package leetCode._2400

object Solution_2311 {
  def longestSubsequence(s: String, k: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, value: Int, pow: Int, cnt: Int): Int =
      if (i < 0 || value + pow > k) s.count(_ == '0') + cnt
      else if (s(i) == '1') f(i - 1, value + pow, pow << 1, cnt + 1)
      else f(i - 1, value, pow << 1, cnt)

    f(i = s.indices.last, value = 0, pow = 1, cnt = 0)
  }
}
