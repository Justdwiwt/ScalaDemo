package leetCode._4000

object Solution_3981 {
  val MOD = 1000000007L

  private def numDistinct(s: String, t: String): Long = {
    val n = s.length
    val m = t.length

    if (n < m) 0L
    else s.indices.foldLeft(Array.fill[Long](m + 1)(0L))((f, i) => {
      f(0) = 1L

      val from = math.min(i, m - 1)
      val until = math.max(m - n + i, 0)

      (from to until by -1).foreach(j => if (s(i) == t(j)) f(j + 1) = (f(j + 1) + f(j)) % MOD)

      f
    })(m)
  }

  def interleaveCharacters(word1: String, word2: String, target: String): Int = {
    val n = target.length
    val m1 = word1.length
    val m2 = word2.length

    val f = Array.fill[Long](n + 1, m1 + 2, m2 + 2)(0L)

    (1 to m1 + 1).foreach(j => (1 to m2 + 1).foreach(f(0)(j)(_) = 1L))

    target.indices.foreach(i => {
      val ch = target(i)

      (0 to m1).foreach(j => {
        (math.max(0, i + 1 - j) to m2).foreach(k => {
          var res =
            f(i + 1)(j)(k + 1) +
              f(i + 1)(j + 1)(k) -
              f(i + 1)(j)(k)

          if (j > 0 && word1(j - 1) == ch)
            res += f(i)(j)(k + 1) - f(i)(j)(k)

          if (k > 0 && word2(k - 1) == ch)
            res += f(i)(j + 1)(k) - f(i)(j)(k)

          f(i + 1)(j + 1)(k + 1) = res % MOD
        })
      })
    })

    (
      f(n)(m1 + 1)(m2 + 1) -
        numDistinct(word1, target) -
        numDistinct(word2, target)
      ).%(MOD).toInt match {
      case x if x < 0 => x + MOD.toInt
      case x => x
    }
  }
}
