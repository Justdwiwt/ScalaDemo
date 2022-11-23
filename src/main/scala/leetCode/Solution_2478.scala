package leetCode

object Solution_2478 {
  def beautifulPartitions(s: String, k: Int, minLength: Int): Int = {
    val M = (1e9 + 7).toInt
    val n = s.length
    if (isPrime(s(n - 1)) || !isPrime(s.head)) return 0
    val ch = s.toCharArray
    val dp = Array.fill(k + 1, n + 1)(0L)
    dp(0)(0) = 1
    (1 to k).foreach(i => {
      var now = 0L
      (minLength to n).foreach(j => {
        if (isPrime(ch(j - minLength))) now = (now + dp(i - 1)(j - minLength)) % M
        if (!isPrime(ch(j - 1))) dp(i)(j) = now
      })
    })
    dp(k)(n).toInt
  }

  def isPrime(c: Char): Boolean = {
    val num = c - '0'
    num == 2 || num == 3 || num == 5 || num == 7
  }
}
