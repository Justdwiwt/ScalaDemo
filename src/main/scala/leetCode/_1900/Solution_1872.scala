package leetCode._1900

object Solution_1872 {
  def stoneGameVIII(stones: Array[Int]): Int = {
    val sum = Array.fill(stones.length + 1)(0)
    stones.indices.foreach(i => sum(i + 1) = sum(i) + stones(i))
    val dp = Array.fill(stones.length + 1)(0)
    dp(stones.length) = sum(stones.length)
    stones.indices.drop(2).reverse.foreach(i => dp(i) = dp(i + 1).max(sum(i) - dp(i + 1)))
    dp(2)
  }
}
