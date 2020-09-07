package leetCode

object Solution_479 {
  def largestPalindrome(n: Int): Int = {
    if (n == 1) return 9
    val pow10 = math.pow(10, n).toInt
    val mx = pow10 - 1
    val p = if (n % 2 == 0) mx else mx - 9
    val lmx = mx.toLong
    val it = (lmx - 1 until lmx / 10 by -1).toIterator
      .map({ ph => val p: Long = ph * pow10 + reverseInt(ph); (ph, p) })
      .map({ case (ph, p: Long) => val lim = (p / mx).toInt; (ph, p: Long, lim) })
      .flatMap({ case (_, palindrome: Long, lim) => (p to lim by (-11)).toIterator
        .withFilter(p => palindrome % p == 0).map(_ => (palindrome % 1337).toInt)
      })
    it.next
  }

  def reverseInt(x: Long): Long = {
    var rev = 0L
    var q = x
    while (q != 0) {
      rev = rev * 10 + q % 10
      q = q / 10
    }
    rev
  }
}
