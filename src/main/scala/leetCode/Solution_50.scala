package leetCode

object Solution_50 {
  def myPow(x: Double, n: Int): Double = {
    var res = 1.0
    var i = n
    var v = x
    while (i != 0) {
      if (i % 2 != 0) res *= v
      v *= v
      i /= 2
    }
    if (n < 0) 1 / res else res
  }
}
