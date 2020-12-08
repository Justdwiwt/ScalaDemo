package leetCode

object Solution_1680 {
  def concatenatedBinary(n: Int): Int = {
    val M = (1e9 + 7).toInt
    var res = 0L
    var bit = 0
    (1 to n).foreach(i => {
      if ((i & (i - 1)) == 0) bit += 1
      res = ((res << bit) + i) % M
    })
    res.toInt
  }
}
