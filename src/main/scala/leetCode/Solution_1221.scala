package leetCode

object Solution_1221 {
  def balancedStringSplit(s: String): Int = {
    var n = 0
    var res = 0
    s.indices.foreach(i => {
      if (s(i) == 'L') n += 1 else n -= 1
      if (n == 0) res += 1
    })
    res
  }
}
