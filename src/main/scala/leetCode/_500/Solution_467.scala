package leetCode._500

object Solution_467 {
  def findSubstringInWraproundString(p: String): Int = {
    var res = 0
    var len = 0
    val cnt = Array.fill(26)(0)
    p.indices.foreach(i => {
      val cur = p(i) - 'a'
      if (i > 0 && p(i - 1) != (cur + 26 - 1) % 26 + 'a') len = 0
      len += 1
      if (len > cnt(cur)) {
        res += len - cnt(cur)
        cnt(cur) = len
      }
    })
    res
  }
}
