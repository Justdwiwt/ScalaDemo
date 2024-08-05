package leetCode._700

object Solution_625 {
  def smallestFactorization(a: Int): Int = {
    @scala.annotation.tailrec
    def f(t: Int, res: Long, n: Long, divisors: List[Int]): Long = divisors match {
      case Nil => if (t == 1) res else 0
      case i :: tail =>
        if (t % i == 0) {
          val newRes = i * n + res
          if (newRes > Int.MaxValue) 0
          else f(t / i, newRes, n * 10, divisors)
        } else f(t, res, n, tail)
    }

    if (a < 10) a
    else {
      val res = f(a, 0L, 1L, (2 to 9).reverse.toList)
      if (res > Int.MaxValue) 0 else res.toInt
    }
  }
}
