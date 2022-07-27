package leetCode

object Solution_1545 {
  def findKthBit(n: Int, k: Int): Char = {
    @scala.annotation.tailrec
    def f(n: Int, k: Int, N: Int, s: String): Char =
      if (n == N) s(k - 1)
      else f(n + 1, k, N, s + "1" + s.reverse.map(49 - _.toInt).mkString)

    f(1, k, n, "0")
  }
}
