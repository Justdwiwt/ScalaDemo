package leetCode._1300

object Solution_1208 {
  def equalSubstring(s: String, t: String, maxCost: Int): Int = {
    var l = 0
    var r = 0
    var cost = 0
    while (r < s.length) {
      cost += (s(r) - t(r)).abs
      if (cost > maxCost) {
        cost -= (s(l) - t(l)).abs
        l += 1
      }
      r += 1
    }
    r - l
  }
}
