package leetCode._200

object Solution_172 {
  def trailingZeroes(n: Int): Int = {
    @scala.annotation.tailrec
    def f(num: Int, acc: Int): Int =
      if (num < 5) acc
      else f(num / 5, acc + num / 5)

    f(n, 0)
  }
}
