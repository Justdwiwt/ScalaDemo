package leetCode._3200

object Solution_3154 {
  private def binomialCoefficient(n: BigInt, k: BigInt): BigInt =
    if (k == 0 || k == n) 1
    else binomialCoefficient(n - 1, k - 1) * n / k

  def waysToReachStair(k: Int): Int = {
    val res = (0 until 31).foldLeft(0)((acc, i) => {
      val cur = BigInt(1) << i
      if (cur - i - 1 <= k && k <= cur) acc + binomialCoefficient(i + 1, cur - k).toInt
      else acc
    })
    res
  }
}
