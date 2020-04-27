package leetCode

object Code_05_02 {
  def printBin(num: Double): String = {
    if (num <= 0 || num >= 1) return "ERROR"
    var x = 0.5
    var v = "0."
    var n = num
    while (n > 0 && v.length < 32) {
      if (n >= x) {
        n -= x
        v += "1"
      } else v += 0
      x /= 2
    }
    if (n == 0) v else "ERROR"
  }
}
