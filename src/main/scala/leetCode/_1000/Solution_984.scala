package leetCode._1000

object Solution_984 {
  def strWithout3a3b(A: Int, B: Int): String = {
    @scala.annotation.tailrec
    def f(a: Int, b: Int, prefix: String): String = {
      if (a == 0) prefix + "b" * b
      else if (b == 0) prefix + "a" * a
      else if (a > b) f(a - 2, b - 1, prefix + "aab")
      else if (a < b) f(a - 1, b - 2, prefix + "bba")
      else f(a - 1, b - 1, prefix + "ab")
    }

    f(A, B, "")
  }
}
