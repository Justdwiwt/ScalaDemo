package leetCode._3600

object Solution_3538 {
  def minTravelTime(l: Int, n: Int, k: Int, position: Array[Int], time: Array[Int]): Int = {
    val s = time.scanLeft(BigInt(0))(_ + _)
    val cache = collection.mutable.Map[(Int, Int, Int), BigInt]()

    def dfs(j: Int, sz: Int, leftK: Int): BigInt =
      if (j == n - 1) {
        if (leftK == 0) BigInt(0) else BigInt(Int.MaxValue)
      } else {
        cache.get((j, sz, leftK)) match {
          case Some(result) => result
          case None =>
            val t = s(j + 1) - s((j - sz).max(0))
            val minTime = (j + 1 until (j + 2 + leftK).min(n)).map(k => dfs(k, k - j - 1, leftK - (k - j - 1)) + (BigInt(position(k) - position(j)) * t)).min
            cache((j, sz, leftK)) = minTime
            minTime
        }
      }

    dfs(0, 0, k).min(BigInt(Int.MaxValue)).toInt
  }
}
