package leetCode

object Solution_2851 {
  private val MAXN = (5e5 + 10).toInt
  private val MOD = (1e9 + 7).toInt

  var next: Array[Int] = Array.fill(MAXN)(0)

  private def initNext(pattern: Array[Char]): Unit = {
    var mx = 0
    pattern.indices.drop(1).foreach(i => {
      while (mx > 0 && pattern(i) != pattern(mx)) mx = next(mx - 1)
      if (pattern(i) == pattern(mx)) mx += 1
      next(i) = mx
    })
  }

  private def kmpSearch(text: Array[Char], pattern: Array[Char]): Int = {
    var res = 0
    val m = pattern.length
    var cnt = 0
    text.indices.foreach(i => {
      while (cnt > 0 && text(i) != pattern(cnt)) cnt = next(cnt - 1)
      if (text(i) == pattern(cnt)) cnt += 1
      if (cnt == m) {
        res += 1
        cnt = next(cnt - 1)
      }
    })
    res
  }

  private def mul(a: Array[Array[Long]], b: Array[Array[Long]], c: Array[Array[Long]]): Unit = {
    val n = a.length
    val m = b.head.length
    val tmp = Array.fill(n, m)(0L)
    a.indices.foreach(i => {
      b.head.indices.foreach(j => {
        a.head.indices.foreach(k => {
          tmp(i)(j) = (tmp(i)(j) + a(i)(k) * b(k)(j)) % MOD
        })
      })
    })
    a.indices.foreach(i => {
      System.arraycopy(tmp(i), 0, c(i), 0, m)
    })
  }

  private def qpow(a: Array[Array[Long]], b: Long): Array[Array[Long]] = {
    val res = Array.fill(a.length, a.head.length)(0L)
    a.indices.foreach(i => res(i)(i) = 1L)
    var t = b
    while (t > 0) {
      if ((t & 1) == 1) mul(res, a, res)
      mul(a, a, a)
      t >>= 1
    }
    res
  }

  def numberOfWays(s: String, t: String, k: Long): Int = {
    val n = s.length
    val ss = s + s.substring(0, n - 1)
    val text = ss.toCharArray
    val pattern = t.toCharArray
    initNext(pattern)
    val c = kmpSearch(text, pattern)
    val f: Array[Array[Long]] = Array(Array(c - 1, c), Array(n - c, n - 1 - c))
    val res = qpow(f, k)
    (if (s.equals(t)) res.head.head else res.head(1)).toInt
  }
}
