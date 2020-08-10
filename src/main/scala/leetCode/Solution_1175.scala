package leetCode

object Solution_1175 {
  private val M = (1e9 + 7).toLong

  def numPrimeArrangements(n: Int): Int = {
    if (n <= 2) return 1
    var prime = 2
    (4 to n).foreach(i => if (isPrime(i)) prime += 1)
    (cal(prime) * cal(n - prime) % M).toInt
  }

  def isPrime(n: Int): Boolean = {
    (2 to math.sqrt(n).toInt).foreach(i => if (n % i == 0) return false)
    true
  }

  def cal(n: Int): Long = {
    var res = 1L
    (2 to n).foreach(i => {
      res *= i
      res %= M
    })
    res
  }
}
