package leetCode._900

object Solution_829 {
  def consecutiveNumbersSum(N: Int): Int = {
    @scala.annotation.tailrec
    def f(N: Int, start: Int, res: Int): Int = {
      if ((N - start * (start + 1) / 2) < 0) return res
      if ((N - start * (start + 1) / 2) % start == 0) f(N, start + 1, res + 1)
      else f(N, start + 1, res)
    }

    f(N, 1, 0)
  }
}
