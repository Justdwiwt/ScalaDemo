package leetCode._2300

object Solution_2291 {
  def maximumProfit(present: Array[Int], future: Array[Int], budget: Int): Int = {
    val dp = Array.fill(budget + 1)(0)
    present.indices.foreach(j => (budget to present(j) by (-1)).foreach(i =>
      dp(i) = dp(i).max(dp(i - present(j)) + future(j) - present(j))
    ))
    dp(budget)
  }
}
