package leetCode._700

object Solution_625 {
  def smallestFactorization(a: Int): Long = {
    var res = 0L
    var n = 1L
    if (a < 10) return a
    var t = a
    (2 to 9).reverse.foreach(i => while (t % i == 0) {
      res = i * n + res
      if (res > Int.MaxValue) return 0
      n *= 10
      t /= i
    })
    if (t == 1) return res.toInt
    0
  }
}
