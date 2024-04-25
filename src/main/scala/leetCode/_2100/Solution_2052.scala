package leetCode._2100

import scala.collection.mutable.ArrayBuffer

object Solution_2052 {
  def minimumCost(sentence: String, k: Int): Int = {
    val words = sentence.split(" ")
    val n = words.length
    val preSum = Array.fill(n + 1)(0)

    words.indices.foreach(i => preSum(i + 1) = preSum(i) + words(i).length)

    def dfs(i: Int, memo: ArrayBuffer[Int]): Int = {
      if (preSum(n) - preSum(i) + n - 1 - i <= k) return 0

      var res = Int.MaxValue
      var t = i + 1

      while (t < n && (preSum(t) - preSum(i) + t - 1 - i) <= k) {
        val cost = math.pow(k - (preSum(t) - preSum(i) + t - 1 - i), 2).toInt
        val nextRes = memo(t) match {
          case -1 => dfs(t, memo)
          case v => v
        }
        res = res.min(cost + nextRes)
        t += 1
      }

      memo(i) = res
      res
    }

    dfs(0, ArrayBuffer.fill(n)(-1))
  }
}
