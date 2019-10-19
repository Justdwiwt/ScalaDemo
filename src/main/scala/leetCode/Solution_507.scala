package leetCode

object Solution_507 {
  def checkPerfectNumber(num: Int): Boolean = {
    if (num == 1) return false
    val n = math.sqrt(num).toInt
    var res = 1
    for (i <- 2 to n)
      if (num % i == 0) res += i + num / i
    res == num
  }
}
