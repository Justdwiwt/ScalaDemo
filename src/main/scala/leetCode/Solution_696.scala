package leetCode

object Solution_696 {
  def countBinarySubstrings(s: String): Int = {
    var last = 0
    var cur = 1
    var res = 0
    (1 until s.length).foreach(i => {
      if (s(i) == s(i - 1)) cur += 1
      else {
        last = cur
        cur = 1
      }
      if (last >= cur) res += 1
    })
    res
  }
}
