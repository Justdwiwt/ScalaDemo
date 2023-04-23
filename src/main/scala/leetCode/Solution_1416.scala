package leetCode

object Solution_1416 {
  def numberOfArrays(s: String, k: Int): Int = {
    val n = s.length
    val dp = Array.ofDim[Long](n + 1)
    dp(n) = 1
    val arr = s.toCharArray.map(_.asDigit)
    (n - 1 to 0 by -1).withFilter(i => arr(i) != 0).foreach(i => {
      var num = arr(i).toLong
      var j = i + 1
      while (1 <= num && num <= k && j < n + 1) {
        dp(i) = (dp(i) + dp(j)) % 1000000007
        if (j < n) num = 10 * num + arr(j)
        j += 1
      }
    })
    dp.head.toInt
  }
}
