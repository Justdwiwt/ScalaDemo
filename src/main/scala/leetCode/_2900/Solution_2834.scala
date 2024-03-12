package leetCode._2900

object Solution_2834 {
  def minimumPossibleSum(n: Int, k: Int): Int = {
    val m = BigInt(n).min(BigInt(k) / 2)
    ((m * (m + 1) + (n - m - 1 + k * 2) * (n - m)) / 2 % 1000000007).toInt
  }
}
