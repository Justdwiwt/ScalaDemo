package leetCode._800

object Solution_738 {
  def monotoneIncreasingDigits(N: Int): Int = {
    var i = 1
    var res = N
    while (i <= res / 10) {
      val n = res / i % 100
      i *= 10
      if (n / 10 > n % 10) res = res / i * i - 1
    }
    res
  }
}
