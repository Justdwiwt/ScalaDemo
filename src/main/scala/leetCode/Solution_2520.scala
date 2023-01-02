package leetCode

object Solution_2520 {
  def countDigits(num: Int): Int = {
    @scala.annotation.tailrec
    def f(n: Int, res: Int): Int =
      if (n == 0) res
      else f(n / 10, if (num % (n % 10) == 0) res + 1 else res)

    f(num, res = 0)
  }
}
