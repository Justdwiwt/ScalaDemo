package leetCode

object Offer_44 {
  def findNthDigit(n: Int): Int = {
    if (n < 10) return n
    var k: Long = 2
    var t: Long = 90
    var N = n.toLong
    N -= 9
    while (N - k * t > 0) {
      N -= k * t
      k += 1
      t *= 10
    }
    val T: Long = math.pow(10, k - (N - 1) % k - 1).toLong
    if ((N - 1) % k == 0) return ((((N - 1) / k) / T + 1) % 10).toInt
    ((((n - 1) / k) / T) % 10).toInt
  }
}
