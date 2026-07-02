package leetCode._4000

object Solution_3932 {
  private def ipow(base: Long, exp: Int): Long =
    Iterator.fill(exp)(base).foldLeft(1L)(_ * _)

  private def f(n: Int, k: Int): Int =
    if (n < 0) 0
    else {
      val x = math.floor(math.pow(n.toDouble, 1.0 / k)).toLong
      val correctX =
        if (ipow(x + 1, k) <= n.toLong) x + 1
        else x
      (correctX + 1).toInt
    }

  def countKthRoots(l: Int, r: Int, k: Int): Int =
    f(r, k) - f(l - 1, k)
}
