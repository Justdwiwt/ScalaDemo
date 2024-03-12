package leetCode._600

object Solution_552 {
  def checkRecord(n: Int): Int = {
    val dp = Array.fill(n + 2)(0L)
    dp(0) = 1
    dp(1) = 2
    dp(2) = 4
    val M = (1e9 + 7).toLong
    var res = 0L
    (3 to n).foreach(i => dp(i) = (dp(i - 1) + dp(i - 2) + dp(i - 3)) % M)
    (0 until n).foreach(i => res = (res + dp(i) * dp(n - 1 - i)) % M)
    ((res + dp(n)) % M).toInt
  }
}
