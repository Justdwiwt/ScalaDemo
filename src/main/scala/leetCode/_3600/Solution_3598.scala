package leetCode._3600

object Solution_3598 {
  def longestCommonPrefix(words: Array[String]): Array[Int] = {
    val n = words.length
    val res = Array.fill(n)(0)
    if (n == 1) return res

    def lcp(s: String, t: String): Int = {
      val len = s.length.min(t.length)
      var i = 0
      while (i < len && s(i) == t(i)) i += 1
      i
    }

    val sufMax = Array.fill(n)(0)
    (1 until n - 1).reverse.foreach(i => sufMax(i) = sufMax(i + 1).max(lcp(words(i), words(i + 1))))

    res(0) = sufMax(1)
    var preMax = 0
    (1 until n - 1).foreach(i => {
      val mid = lcp(words(i - 1), words(i + 1))
      res(i) = preMax.max(mid.max(sufMax(i + 1)))
      preMax = preMax.max(lcp(words(i - 1), words(i)))
    })
    res(n - 1) = preMax
    res
  }
}
