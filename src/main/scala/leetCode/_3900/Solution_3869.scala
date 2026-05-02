package leetCode._3900

import scala.collection.Searching.search

object Solution_3869 {
  def countFancy(l: Long, r: Long): Long = {
    val res = collection.mutable.ArrayBuffer[Long]()
    (1 to 9).foreach(len => (1 to 9).combinations(len).foreach(res += _.mkString.toLong))
    (1 to 10).foreach(len => (0 to 9).reverse.combinations(len).foreach(comb => {
      val numStr = comb.mkString
      if (numStr.length == 1 || !numStr.startsWith("0"))
        res += numStr.toLong
    }))
    val precomputed = res.distinct.sorted

    val validSums = precomputed.filter(_ <= 135).map(_.toInt).toSet

    def countValidSumsUpTo(limit: Long): Long = {
      if (limit < 0) return 0L
      val sStr = limit.toString
      val n = sStr.length

      val memo = Array.fill(n, 136, 2)(-1L)

      def dp(idx: Int, currentSum: Int, restricted: Int): Long = {
        if (currentSum > 135) return 0L

        if (idx == n) {
          return if (validSums.contains(currentSum)) 1L else 0L
        }

        if (memo(idx)(currentSum)(restricted) != -1L) {
          return memo(idx)(currentSum)(restricted)
        }

        val maxDigit = if (restricted == 0) 9 else sStr(idx).asDigit
        var ways = 0L

        (0 to maxDigit).foreach(d => {
          val nextRestricted = if (restricted == 0 || d < maxDigit) 0 else 1
          ways += dp(idx + 1, currentSum + d, nextRestricted)
        })

        memo(idx)(currentSum)(restricted) = ways
        ways
      }

      dp(0, 0, 1)
    }

    val sumsCount = countValidSumsUpTo(r) - countValidSumsUpTo(l - 1)

    var extra = 0L
    val leftIdx = precomputed.search(l).insertionPoint
    val rightIdx = precomputed.search(r + 1).insertionPoint

    (leftIdx until rightIdx).foreach(i => {
      val num = precomputed(i)
      val sumDigits = num.toString.map(_.asDigit).sum
      if (!validSums.contains(sumDigits)) extra += 1
    })
    sumsCount + extra
  }
}
