package leetCode._1000

object Solution_1000 {
  def mergeStones(stones: Array[Int], K: Int): Int = {
    if ((stones.length - 1) % (K - 1) != 0) return -1
    val dp = Array.fill(stones.length, stones.length)(0)
    val sum = Array.fill(stones.length + 1)(0)
    stones.indices.foreach(i => {
      dp(i)(i) = stones(i)
      sum(i + 1) += sum(i) + stones(i)
    })
    stones.indices.drop(1).foreach(j => (0 until j).reverse.foreach(i => {
      dp(i)(j) = dp(i)(i) + dp(i + 1)(j)
      (i + K - 1 until j by (K - 1)).foreach(cut => dp(i)(j) = dp(i)(j).min(dp(i)(cut) + dp(cut + 1)(j)))
      if ((j - i) % (K - 1) == 0) dp(i)(j) += sum(j + 1) - sum(i)
    }))
    dp.head(stones.length - 1) - sum(stones.length)
  }
}
