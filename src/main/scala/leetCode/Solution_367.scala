package leetCode

object Solution_367 {
  def isPerfectSquare(num: Int): Boolean = {
    var t = num
    var i = 1
    while (t > 0) {
      t -= i
      i += 2
    }
    t == 0
  }
}
