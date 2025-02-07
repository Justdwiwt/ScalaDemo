package leetCode._3500

object Solution_3441 {
  def minCostGoodCaption(s: String): String = {
    val n = s.length
    if (n < 3) return ""
    val sArray = s.map(c => c - 'a')
    val f = Array.fill(n + 1, 26)(0)
    val minJ = Array.fill(n + 1)(0)
    val nxt = Array.fill(n + 1, 26)(0)
    ((n - 1) to 0 by -1).foreach(i => {
      var mn = Int.MaxValue
      (0 until 26).foreach(j => {
        val res = f(i + 1)(j) + (sArray(i) - j).abs
        val res2 = if (i <= n - 6) f(i + 3)(minJ(i + 3)) + (sArray(i) - j).abs + (sArray(i + 1) - j).abs + (sArray(i + 2) - j).abs else Int.MaxValue
        if (res2 < res || (res2 == res && minJ(i + 3) < j)) {
          f(i)(j) = res2
          nxt(i)(j) = minJ(i + 3)
        } else {
          f(i)(j) = res
          nxt(i)(j) = j
        }
        if (f(i)(j) < mn) {
          mn = f(i)(j)
          minJ(i) = j
        }
      })
    })
    val res = Array.fill(n)(' ')
    var i = 0
    var j = minJ(0)
    while (i < n) {
      res(i) = (j + 'a').toChar
      val k = nxt(i)(j)
      if (k == j) i += 1
      else {
        res(i + 1) = res(i)
        res(i + 2) = res(i)
        i += 3
        j = k
      }
    }
    res.mkString
  }
}
