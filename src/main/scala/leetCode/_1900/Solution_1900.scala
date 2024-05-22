package leetCode._1900

object Solution_1900 {
  def earliestAndLatest(n: Int, f: Int, s: Int): Array[Int] = {
    val memo = Array.ofDim[Int](n + 1, n, n, 2)
    dfs(n, f - 1, s - 1, memo)
  }

  private def dfs(n: Int, f: Int, s: Int, memo: Array[Array[Array[Array[Int]]]]): Array[Int] = {
    if (f + s == n - 1) Array(1, 1)
    else if (f >= n - f - 1 || f > n - s - 1) {
      val l = n - s - 1
      val r = n - f - 1
      dfs(n, l, r, memo)
    }
    else if (memo(n)(f)(s).head != 0) memo(n)(f)(s)
    else {
      val mid = (n + 1) >> 1
      val as = (0 to f)
        .flatMap(i => (0 until s.min(n - s - 1) - f).map(j => {
          val a = if (s < mid) dfs(mid, i, i + j + 1, memo) else dfs(mid, i, (2 * s - n + 1) / 2 + i + j + 1, memo)
          (a.head, a(1))
        }))
        .foldLeft(Array(Int.MaxValue, Int.MinValue))((acc, a) => Array(a._1.min(acc.head), a._2.max(acc(1))))
      as(0) += 1
      as(1) += 1
      memo(n)(f)(s) = as
      as
    }
  }
}
