package leetCode

object Solution_647 {
  def countSubstrings(s: String): Int = {
    val dp = Array.ofDim[Boolean](s.length, s.length)
    var cnt = 0
    val ch = s.toCharArray
    s.indices.foreach(j => (0 to j).foreach(i => {
      if (j == i && ch(j) == ch(i)) {
        dp(i)(j) = true
        cnt += 1
      } else if (j - i == 1 && ch(i) == ch(j)) {
        dp(i)(j) = true
        cnt += 1
      } else if (j - i > 1 && dp(i + 1)(j - 1) && ch(i) == ch(j)) {
        dp(i)(j) = true
        cnt += 1
      }
    }))
    cnt
  }
}
