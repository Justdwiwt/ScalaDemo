package leetCode

object Code_17_06 {
  var s: Array[Char] = _
  var dp: Array[Array[Int]] = _

  def numberOf2sInRange(n: Int): Int = {
    s = Integer.toString(n).toCharArray
    dp = Array.fill(s.length)(Array.fill(s.length)(-1))
    f(0, 0, isLimit = true)
  }

  private def f(i: Int, cnt2: Int, isLimit: Boolean): Int = {
    if (i == s.length) return cnt2
    if (!isLimit && dp(i)(cnt2) >= 0) return dp(i)(cnt2)
    var res = 0
    val up = if (isLimit) s(i) - '0' else 9
    (0 until up + 1).foreach(d => res += f(i + 1, cnt2 + (if (d == 2) 1 else 0), isLimit && d == up))
    if (!isLimit) dp(i)(cnt2) = res
    res
  }
}
