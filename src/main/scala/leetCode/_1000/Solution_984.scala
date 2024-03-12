package leetCode._1000

object Solution_984 {
  def strWithout3a3b(A: Int, B: Int): String = {
    var res = ""
    var a = A
    var b = B
    while (a > 0 || b > 0) {
      if (a == 0) {
        res += 'b'
        b -= 1
      }
      else if (b == 0) {
        res += 'a'
        a -= 1
      }
      else if (a > b) {
        res += "aab"
        a -= 2
        b -= 1
      } else if (a < b) {
        res += "bba"
        a -= 1
        b -= 2
      } else if (a == b) {
        res += "ab"
        a -= 1
        b -= 1
      }
    }
    res
  }
}
