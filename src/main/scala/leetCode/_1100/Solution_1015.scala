package leetCode._1100

object Solution_1015 {
  def smallestRepunitDivByK(K: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, n: Int): Int = {
      val next = (n * 10) % K + 1
      if (next % K == 0) i
      else if (i <= K) f(i + 1, next)
      else -1
    }

    if (K % 2 == 0) -1 else f(1, 0)
  }
}
