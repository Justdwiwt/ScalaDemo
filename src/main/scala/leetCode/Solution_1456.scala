package leetCode

object Solution_1456 {
  private val diff = Array('a', 'e', 'i', 'o', 'u')

  def maxVowels(s: String, k: Int): Int = {
    var cnt = 0
    var res = 0
    s.indices.foreach(i => {
      cnt += check(s(i))
      if (i >= k) cnt -= check(s(i - k))
      res = res.max(cnt)
    })
    res
  }

  def check(c: Char): Int = if (diff.contains(c)) 1 else 0
}
