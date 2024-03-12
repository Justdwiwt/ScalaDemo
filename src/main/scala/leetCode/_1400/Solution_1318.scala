package leetCode._1400

object Solution_1318 {
  def minFlips(a: Int, b: Int, c: Int): Int = {
    def f(d: Int): Int = if (d > 0) f(d & d - 1) + 1 else 0

    f((a | b) ^ c) + f(a & b & ~c)
  }
}
