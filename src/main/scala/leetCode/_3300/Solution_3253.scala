package leetCode._3300

object Solution_3253 {
  def minimumCost(target: String, words: Array[String], costs: Array[Int]): Int = {
    val n = target.length
    val dp = Array.fill(n + 1)(Int.MaxValue)
    dp(0) = 0
    target.indices.foreach(i => {
      if (dp(i) != Int.MaxValue)
        words.zip(costs).foreach { case (word, cost) =>
          val len = word.length
          if (i + len <= n && target.substring(i, i + len) == word)
            dp(i + len) = dp(i + len).min(dp(i) + cost)
        }
    })
    if (dp(n) != Int.MaxValue) dp(n) else -1
  }
}
