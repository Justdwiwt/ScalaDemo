package leetCode._3800

object Solution_3790 {
  def minAllOneMultiple(k: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, n: Int): Int = {
      val next = (n * 10) % k + 1
      if (next % k == 0) i
      else if (i <= k) f(i + 1, next)
      else -1
    }

    if (k % 2 == 0) -1 else f(1, 0)
  }
}
