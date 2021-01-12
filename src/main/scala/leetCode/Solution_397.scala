package leetCode

object Solution_397 {
  def integerReplacement(n: Int): Int = f(n)

  def f(n: Long): Int = {
    if (n == 1) return 0
    if (n % 2 == 0) 1 + f(n / 2)
    else 1 + f(n + 1).min(f(n - 1))
  }
}
