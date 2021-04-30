package leetCode

object Solution_1837 {
  def sumBase(n: Int, k: Int): Int = {
    if (n == 0) return 0
    n % k + sumBase(n / k, k)
  }
}
