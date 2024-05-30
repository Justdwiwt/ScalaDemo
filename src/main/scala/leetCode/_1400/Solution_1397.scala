package leetCode._1400

object Solution_1397 {
  private val M = 1e9.toInt + 7

  def findGoodStrings(n: Int, s1: String, s2: String, evil: String): Int = {
    val p = evil.toCharArray
    val prefix = calcuPrefixFunction(p)

    val initialDp = evil.indices.flatMap(i =>
      List(
        (n, 0, i) -> 1L,
        (n, 1, i) -> 1L,
        (n, 2, i) -> 1L,
        (n, 3, i) -> 1L
      )
    ).toMap.withDefaultValue(0L)

    val dp = (n - 1 to 0 by -1).foldLeft(initialDp)((dpAcc, i) => {
      evil.indices.foldLeft(dpAcc)((dpAccInner, j) => {

        val dp0 = (s1.charAt(i) to s2.charAt(i)).foldLeft(0L)((acc, k) => {
          val state = if (k == s1.charAt(i) && k == s2.charAt(i)) 0
          else if (k == s1.charAt(i)) 1
          else if (k == s2.charAt(i)) 2
          else 3
          (acc + dpAccInner(i + 1, state, getNext(prefix, p, k, j))) % M
        })

        val dp1 = (s1.charAt(i) to 'z').foldLeft(0L)((acc, k) => {
          val state = if (k == s1.charAt(i)) 1 else 3
          (acc + dpAccInner(i + 1, state, getNext(prefix, p, k, j))) % M
        })

        val dp2 = ('a' to s2.charAt(i)).foldLeft(0L)((acc, k) => {
          val state = if (k == s2.charAt(i)) 2 else 3
          (acc + dpAccInner(i + 1, state, getNext(prefix, p, k, j))) % M
        })

        val dp3 = ('a' to 'z').foldLeft(0L)((acc, k) => (acc + dpAccInner(i + 1, 3, getNext(prefix, p, k, j))) % M)

        dpAccInner
          .updated((i, 0, j), dp0)
          .updated((i, 1, j), dp1)
          .updated((i, 2, j), dp2)
          .updated((i, 3, j), dp3)
      })
    })

    dp(0, 0, 0).toInt
  }

  private def calcuPrefixFunction(p: Array[Char]): Array[Int] = {
    val n = p.length
    val prefixArray = Array.ofDim[Int](n)
    var j = 0

    p.indices.drop(1).foreach(i => {
      while (j > 0 && p(i) != p(j)) j = prefixArray(j - 1)
      if (p(i) == p(j)) j += 1
      prefixArray(i) = j
    })

    prefixArray
  }

  private def getNext(prefix: Array[Int], p: Array[Char], c: Char, j: Int): Int = {
    @scala.annotation.tailrec
    def loop(tempJ: Int): Int =
      if (tempJ > 0 && c != p(tempJ)) loop(prefix(tempJ - 1))
      else if (c == p(tempJ)) tempJ + 1
      else tempJ

    loop(j)
  }
}
