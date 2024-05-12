package leetCode._700

import scala.collection.mutable

object Solution_656 {
  def cheapestJump(coins: Array[Int], maxJump: Int): List[Int] = {
    val buffer = mutable.ListBuffer.empty[Int]
    val n = coins.length
    val dp = Array.fill(n + 1)(Int.MaxValue)
    val nextIndices = Array.fill(n + 1)(0)

    if (coins(n - 1) >= 0) dp(n) = coins(n - 1)
    else return buffer.toList

    coins
      .indices
      .drop(1)
      .reverse
      .withFilter(i => coins(i - 1) >= 0)
      .map { i => val start = i + 1; (i, start) }
      .map { case (i, start) => val end = n.min(i + maxJump); (i, start, end) }
      .foreach { case (i, start, end) => (start to end)
        .withFilter(j => dp(j) != Int.MaxValue && coins(i - 1) + dp(j) < dp(i))
        .foreach(j => {
          dp(i) = coins(i - 1) + dp(j)
          nextIndices(i) = j
        })
      }

    if (dp(1) == Int.MaxValue) return buffer.toList

    var index = 1
    while (index < n && nextIndices(index) != 0) {
      buffer += index
      index = nextIndices(index)
    }
    buffer += n
    buffer.toList
  }
}
