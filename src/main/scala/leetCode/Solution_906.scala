package leetCode

object Solution_906 {
  def superpalindromesInRange(L: String, R: String): Int = {
    var ans = 0
    (1 to math.pow(10, (R.length + 1) / 2).toInt)
      .withFilter(i => isPalindrome(i.toString))
      .withFilter(i => func(BigInt(i) * BigInt(i), BigInt(L)))
      .foreach(i => {
        if (BigInt(i) * BigInt(i) > BigInt(R)) return ans
        ans += 1
      })
    ans
  }

  def func(n: BigInt, L: BigInt): Boolean = n >= L && isPalindrome(n.toString)

  def isPalindrome(s: String): Boolean = s.reverse == s
}
