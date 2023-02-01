package leetCode

object Solution_2550 {
  def monkeyMove(n: Int): Int = {
    val M = 1000000007

    @annotation.tailrec
    def f(base: Long, pow: Int, res: Long): Int =
      if (pow == 0) res.toInt
      else if (pow % 2 == 0) f((base * base) % M, pow / 2, res)
      else f((base * base) % M, pow / 2, (res * base) % M)

    java.lang.Math.floorMod(f(2, n, 1) - 2, M)
  }
}
