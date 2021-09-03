package leetCode

object Solution_372 {
  def superPow(a: Int, b: Array[Int]): Int = {
    val e = a % 1337
    fastExp(e, f(b) % 570, 1337)
  }

  def f(b: Array[Int]): Int =
    if (b.isEmpty) 0
    else (b.head * fastExp(10, b.length - 1, 570) + f(b.tail)) % 570


  def fastExp(base: Int, exp: Int, mod: Int): Int = {
    require(exp >= 0)

    @scala.annotation.tailrec
    def g(base: Int, exp: Int, acc: Int): Int = {
      if (exp == 0) acc % mod
      else if ((exp % 2) != 0) g(base, exp - 1, base * acc % mod)
      else g(base * base % mod, exp / 2, acc)
    }

    g(base % mod, exp, 1)
  }
}
