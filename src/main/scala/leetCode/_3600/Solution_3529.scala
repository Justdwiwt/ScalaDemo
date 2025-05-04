package leetCode._3600

object Solution_3529 {
  def countCells(grid: Array[Array[Char]], pattern: String): Int = {
    val m = grid.length
    val n = grid.head.length

    val hText = grid.flatten
    val vText = grid.head.indices.flatMap(j => grid.map(row => row(j)))

    def calcPi(pattern: Array[Char]): Array[Int] = {
      val pi = Array.ofDim[Int](pattern.length)
      var matchLen = 0
      pattern.indices.drop(1).foreach(i => {
        while (matchLen > 0 && pattern(matchLen) != pattern(i)) matchLen = pi(matchLen - 1)
        if (pattern(matchLen) == pattern(i)) matchLen += 1
        pi(i) = matchLen
      })
      pi
    }

    def kmpSearch(text: Array[Char], pattern: Array[Char], pi: Array[Int]): Array[Int] = {
      val n = text.length
      val diff = Array.ofDim[Int](n + 1)
      var matchLen = 0
      text.indices.foreach(i => {
        while (matchLen > 0 && pattern(matchLen) != text(i)) matchLen = pi(matchLen - 1)
        if (pattern(matchLen) == text(i)) matchLen += 1
        if (matchLen == pattern.length) {
          diff(i - pattern.length + 1) += 1
          diff(i + 1) -= 1
          matchLen = pi(matchLen - 1)
        }
      })
      text.indices.drop(1).foreach(i => diff(i) += diff(i - 1))
      diff
    }

    val pat = pattern.toCharArray
    val pi = calcPi(pat)

    val inPatternH = kmpSearch(hText, pat, pi)
    val inPatternV = kmpSearch(vText.toArray, pat, pi)

    (0 until m * n).count(i => inPatternH(i) > 0 && inPatternV(i % n * m + i / n) > 0)
  }
}
