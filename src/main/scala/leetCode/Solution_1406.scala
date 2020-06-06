package leetCode

object Solution_1406 {
  def stoneGameIII(stoneValue: Array[Int]): String = {
    val dp = Array.fill(stoneValue.length)(0)
    val sum = Array.fill(stoneValue.length)(0)
    stoneValue.indices.reverse.foreach(i => sum(i) = (if (i + 1 < stoneValue.length) sum(i + 1) else 0) + stoneValue(i))
    dp.indices.reverse.foreach(i => dp(i) = sum(i) - List(i + 1, i + 2, i + 3).map(x => if (x < stoneValue.length) dp(x) else 0).min)
    if (dp(0) * 2 == sum(0)) "Tie"
    else if (dp(0) * 2 > sum(0)) "Alice"
    else "Bob"
  }
}
