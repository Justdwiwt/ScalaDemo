package leetCode._3400

object Solution_3339 {
  val M: Int = 1000000007

  def countOfArrays(n: Int, m: Int, k: Int): Int = {
    val odds: Int = (m + 1) / 2
    val evens: Int = m - odds

    def dp(start: Int, consecEven: Int, prevEven: Boolean, cache: Map[(Int, Int, Boolean), Long]): (Long, Map[(Int, Int, Boolean), Long]) = {
      if (start == n) return (if (consecEven == k) 1 else 0, cache)
      if (consecEven > k) return (0, cache)

      val key = (start, consecEven, prevEven)
      cache.get(key) match {
        case Some(value) => (value, cache)
        case None =>
          val (evenResult, evenCache) = dp(start + 1, if (prevEven) consecEven + 1 else consecEven, prevEven = true, cache)
          val (oddResult, oddCache) = dp(start + 1, consecEven, prevEven = false, evenCache)
          val result = if (prevEven) (evens * evenResult % M + odds * oddResult % M) % M
          else (evens * evenResult % M + odds * oddResult % M) % M

          (result, oddCache + (key -> result))
      }
    }

    dp(0, 0, prevEven = false, Map.empty)._1.toInt
  }
}
