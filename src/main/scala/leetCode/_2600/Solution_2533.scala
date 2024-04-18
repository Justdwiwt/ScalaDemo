package leetCode._2600

object Solution_2533 {
  def goodBinaryStrings(minLength: Int, maxLength: Int, oneGroup: Int, zeroGroup: Int): Int = {
    val M = 1000000007
    val dp = Array.fill(maxLength + 1)(0)
    dp(0) = 1
    var res = 0L

    (1 to maxLength).foreach(i => {
      if (i - oneGroup >= 0) dp(i) = (dp(i) + dp(i - oneGroup)) % M
      if (i - zeroGroup >= 0) dp(i) = (dp(i) + dp(i - zeroGroup)) % M
      if (i >= minLength) res = (res + dp(i)) % M
    })
    res.toInt
  }
}
