package leetCode._3300

object Solution_3251 {
  private val M = BigInt(10).pow(9) + 7

  def countOfPairs(nums: Array[Int]): Int = {
    val n = nums.length

    if (n == 1) return comb(nums.last + n, n).toInt

    val initPre = nums.last

    val (isValid, finalPre) = nums
      .reverse
      .sliding(2)
      .foldLeft((true, initPre)) {
        case ((isValid, pre), Array(a, b)) =>
          if (!isValid) (isValid, pre)
          else if (a > b + pre) (false, pre)
          else if (a > b) (isValid, pre - (a - b))
          else (isValid, pre)
        case ((_, pre), _) => (false, pre)
      }

    if (isValid && finalPre >= 0) (comb(finalPre + n, n) % M).toInt else 0
  }

  private def comb(n: Int, k: Int): BigInt =
    if (k > n) BigInt(0)
    else {
      val numerator = factorial(n)
      val denominator = factorial(k) * factorial(n - k)
      numerator / denominator
    }

  private def factorial(x: Int): BigInt =
    (BigInt(1) to BigInt(x)).product
}
