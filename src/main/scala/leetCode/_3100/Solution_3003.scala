package leetCode._3100

object Solution_3003 {
  var seg = 1
  var mask = 0
  var size = 0

  def maxPartitionsAfterOperations(S: String, k: Int): Int = {
    if (k == 26) return 1
    val s = S.toCharArray
    val n = s.length
    val sufSeg = Array.fill(n + 1)(0)
    val sufMask = Array.fill(n + 1)(0)
    (n - 1 to 0 by -1).foreach(i => {
      f(s(i), k)
      sufSeg(i) = seg
      sufMask(i) = mask
    })
    var res = seg
    seg = 1
    mask = 0
    size = 0
    (0 until n).foreach(i => {
      var t = seg + sufSeg(i + 1)
      val unionSize = Integer.bitCount(mask | sufMask(i + 1))
      if (unionSize < k) t -= 1
      else if (unionSize < 26 && size == k && Integer.bitCount(sufMask(i + 1)) == k) t += 1
      res = res.max(t)
      f(s(i), k)
    })
    res
  }

  private def f(c: Char, k: Int): Unit = {
    var bit = 1 << (c - 'a')
    if ((mask & bit) != 0) {
      return
    }
    size += 1
    if (size > k) {
      seg += 1
      mask = bit
      size = 1
    } else mask |= bit
  }
}
