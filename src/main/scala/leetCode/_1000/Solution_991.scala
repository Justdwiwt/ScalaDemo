package leetCode._1000

object Solution_991 {
  def brokenCalc(X: Int, Y: Int): Int = {
    var res = 0
    val x = X
    var y = Y
    while (y > x)
      if ((y & 1) == 0) {
        res += 1
        y >>= 1
      } else {
        res += 2
        y = (y + 1) >> 1
      }
    res += x - y
    res
  }
}
