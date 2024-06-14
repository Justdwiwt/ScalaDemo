package leetCode._2000

object Solution_1977 {
  def numberOfCombinations(num: String): Int = {
    val n = num.length
    val M = 1000000007
    val pre = Array.fill(n + 1)(Array.fill(n + 1)(0))
    pre(0)(0) = 1
    Range(1, n + 1, 1).foreach(i => Range(1, i + 1, 1).foreach(j => {
      var cur = 0
      if (num(i - j) != '0') {
        if (i - 2 * j >= 0 && num.substring(i - j, i) >= num.substring(i - 2 * j, i - j)) cur = pre(i - j)(j)
        else cur = pre(i - j)((j - 1).min(i - j))
      }
      pre(i)(j) = (pre(i)(j - 1) + cur) % M
    }))
    pre.last.last
  }
}
