package leetCode._3400

import scala.math.BigInt.int2bigInt

object Solution_3352 {
  private val M = 1000000007

  def countKReducibleNumbers(s: String, k: Int): Int = {
    val n = s.length
    val memo = Array.fill(n, n + 1)(-1)
    var res = 0L
    val f = Array.ofDim[Int](n + 1)

    (1 to n).foreach(i => {
      f(i) = f(i.bitCount) + 1
      if (f(i) <= k) res += dfs(0, i, isLimit = true, s.toCharArray, memo)
    })

    (res % M).toInt
  }

  private def dfs(i: Int, left1: Int, isLimit: Boolean, s: Array[Char], memo: Array[Array[Int]]): Int = {
    if (i == s.length) {
      if (!isLimit && left1 == 0) return 1
      else return 0
    }

    if (!isLimit && memo(i)(left1) != -1) return memo(i)(left1)

    val up = if (isLimit) s(i) - '0' else 1
    var res = 0

    (0 to up.min(left1)).foreach(d => res = (res + dfs(i + 1, left1 - d, isLimit && d == up, s, memo)) % M)

    if (!isLimit) memo(i)(left1) = res

    res
  }
}
