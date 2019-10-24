package leetCode

object Solution_507 {
  def checkPerfectNumber(num: Int): Boolean = {
    if (num == 1) return false
    val n = math.sqrt(num).toInt
    var res = 1
    (2 to n).foreach(i => if (num % i == 0) res += i + num / i)
    res == num
  }
}
