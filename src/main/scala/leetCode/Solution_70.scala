package leetCode

object Solution_70 {
  def climbStairs(n: Int): Int = {
    if (n <= 2) return n
    var i1 = 1
    var i2 = 2
    var i = 3
    while (i <= n) {
      val temp = i1 + i2
      i1 = i2
      i2 = temp
      i += 1
    }
    i2
  }
}
