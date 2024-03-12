package leetCode._1700

object Solution_1639 {
  def numWays(words: Array[String], target: String): Int = {
    val dp = Array.ofDim[Long](target.length)
    val M = 1000000007
    words.head.indices.foreach(i => {
      val tmp = Array.ofDim[Int](26)
      words.indices.foreach(j => tmp(words(j).charAt(i) - 'a') += 1)
      (i.min(target.length - 1) to 0 by -1).foreach(j => if (tmp(target.charAt(j) - 'a') > 0) {
        dp(j) += (if (j == 0) tmp(target.charAt(j) - 'a') else dp(j - 1) * tmp(target.charAt(j) - 'a'))
        dp(j) %= M
      })
    })
    dp(dp.length - 1).toInt
  }
}
