package leetCode

object Solution_1137 {

  def tribonacci(n: Int): Int = func(0, 1, 1, n)

  @scala.annotation.tailrec
  def func(a: Int, b: Int, c: Int, n: Int): Int = if (n == 0) a else func(b, c, a + b + c, n - 1)

}
