package leetCode

object Solution_405 {
  def toHex(num: Int): String = {
    var res = new String
    val str = "0123456789abcedf".toCharArray
    var n = num
    while (num != 0) {
      val end = n & 15
      res = str(end) + res
      n >>>= 4
    }
    if (res.isEmpty) "0" else res
  }
}
