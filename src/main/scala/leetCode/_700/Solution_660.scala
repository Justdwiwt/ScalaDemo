package leetCode._700

object Solution_660 {
  def newInteger(n: Int): Int = {
    var t = n
    var i = 0
    var res = 0
    while (t > 0) {
      res += t % 9 * math.pow(10, i).toInt
      t /= 9
      i += 1
    }
    res
  }
}
