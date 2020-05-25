package leetCode

object Solution_1446 {
  def maxPower(s: String): Int = {
    var cur = 1
    var res = 1
    (1 until s.length).foreach(i => {
      if (s(i - 1) == s(i)) {
        cur += 1
        res = res.max(cur)
      }
      else cur = 1
    })
    res
  }
}
