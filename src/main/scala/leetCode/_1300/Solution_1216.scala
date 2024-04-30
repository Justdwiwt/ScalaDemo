package leetCode._1300

object Solution_1216 {
  def isValidPalindrome(s: String, k: Int): Boolean = {
    val n = s.length
    if (1 + k >= n) true
    else {
      val dp = Array.ofDim[Int](n, n)
      var foundValidPalindrome = false
      ((n - 2) to 0 by -1)
        .withFilter(_ => !foundValidPalindrome)
        .foreach(l => {
          dp(l)(l) = 1
          (l + 1 until n)
            .withFilter(_ => !foundValidPalindrome)
            .foreach(r => {
              if (s.charAt(l) == s.charAt(r)) dp(l)(r) = dp(l + 1)(r - 1) + 2
              else dp(l)(r) = dp(l + 1)(r).max(dp(l)(r - 1))
              if (dp(l)(r) + k >= n) foundValidPalindrome = true
            })
        })
      foundValidPalindrome
    }
  }
}
