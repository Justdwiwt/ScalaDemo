package leetCode

object Solution_263 {
  def isUgly(num: Int): Boolean = {
    var res = num
    if (res <= 0) return false
    while (res % 2 == 0) res /= 2
    while (res % 3 == 0) res /= 3
    while (res % 5 == 0) res /= 5
    res == 1
  }
}
