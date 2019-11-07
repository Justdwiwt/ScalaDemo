package leetCode

object Solution_1017 {
  def baseNeg2(N: Int): String = {
    var res = ""
    if (N == 0) return "0"
    var n = N
    while (n != 0)
      if (n % 2 == 0) {
        res = "0" + res
        n /= -2
      } else {
        res = "1" + res
        n = (n - 1) / -2
      }
    res
  }
}
