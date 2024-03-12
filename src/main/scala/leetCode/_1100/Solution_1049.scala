package leetCode._1100

object Solution_1049 {
  def lastStoneWeightII(stones: Array[Int]): Int = {
    var sum = 0
    val dp = Array.fill(8000)(0)
    stones.indices.foreach(i => sum += stones(i))
    val res = sum >> 1
    stones.indices.foreach(i => (res to stones(i) by (-1)).foreach(j => dp(j) = dp(j).max(dp(j - stones(i)) + stones(i))))
    (sum - dp(res) - dp(res)).abs
  }
}
