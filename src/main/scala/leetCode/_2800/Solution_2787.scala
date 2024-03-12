package leetCode._2800

import scala.collection.mutable

object Solution_2787 {
  def numberOfWays(n: Int, x: Int): Int = {
    val M = (1e9 + 7).toInt
    val nums = mutable.Buffer.empty[Int]
    var idx = 1
    while (math.pow(idx, x) <= n) {
      nums += math.pow(idx, x).toInt
      idx += 1
    }

    val dp = Array.fill(n + 1)(0)
    dp(0) = 1

    nums.indices.foreach(i => (n to nums(i) by -1).foreach(j => dp(j) = (dp(j) + dp(j - nums(i))) % M))
    dp(n)
  }
}
