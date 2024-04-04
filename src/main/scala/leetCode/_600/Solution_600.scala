package leetCode._600

object Solution_600 {
  def findIntegers(n: Int): Int =
    f(n, 1, 1) + 1

  private def f(max: Int, n: Int, bit: Int): Int = {
    if (n == max) 1
    else if (n > max) 0
    else if (bit == 1) 1 + f(max, n << 1, 0)
    else 1 + f(max, (n << 1) + 1, 1) + f(max, n << 1, 0)
  }
}
