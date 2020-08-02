package leetCode

object Solution_1525 {
  def numSplits(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    val l = Array.fill(26)(0)
    val r = Array.fill(26)(0)
    var res = 0
    var lCnt = 0
    var rCnt = 0
    s.indices.foreach(i => {
      val t = s(i) - 'a'
      if (r(t) == 0) rCnt += 1
      r(t) += 1
    })
    s.indices.foreach(i => {
      val t = s(i) - 'a'
      if (l(t) == 0) lCnt += 1
      l(t) += 1
      r(t) -= 1
      if (r(t) == 0) rCnt -= 1
      if (lCnt == rCnt) res += 1
    })
    res
  }
}
