package leetCode

object Solution_397 {
  def integerReplacement(n: Int): Int = {
    var res = 0
    var t = n
    while (t > 3) {
      if (t % 2 != 0) {
        t >>= 1
        if (t % 2 != 0) t += 1
        res += 2
      } else {
        t >>= 1
        res += 1
      }
    }
    res + t - 1
  }
}
