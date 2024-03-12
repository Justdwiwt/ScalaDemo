package leetCode._1500

object Solution_1411 {
  def numOfWays(n: Int): Int = {
    val M = (1e9 + 7).toLong
    var a = 6L
    var b = 6L
    var res = 12L
    var N = n - 1
    while (N > 0) {
      res = (5 * a + 4 * b) % M
      val t = (3 * a + 2 * b) % M
      b = (2 * a + 2 * b) % M
      a = t
      N -= 1
    }
    res.toInt
  }
}
