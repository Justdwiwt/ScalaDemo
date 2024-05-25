package leetCode._2900

object Solution_2819 {
  def minimumRelativeLosses(prices: Array[Int], queries: Array[Array[Int]]): Array[Long] = {
    val n = prices.length
    val sorted = prices.sorted
    val sum = sorted.scanLeft(0L)(_ + _)

    def calculateLoss(k: Int, m: Int): Long = {
      if (n == m) {
        val x = binarySearch(sorted, k)
        sum(x) + k.toLong * (n - x) * 2 - (sum(n) - sum(x))
      } else {
        val need = n - m
        var idx = m
        var lo = 0
        var hi = m - 1
        while (lo <= hi) {
          val mid = (lo + hi) >> 1
          if (k - sorted(mid) > sorted(mid + need) - k) lo = mid + 1
          else {
            hi = mid - 1
            idx = mid
          }
        }
        val left = sum(idx)
        val right = k.toLong * (n - idx - need) * 2 - (sum(n) - sum(idx + need))
        left + right
      }
    }

    queries.map { case Array(k, m) => calculateLoss(k, m) }
  }

  private def binarySearch(arr: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = arr.length - 1
    var res = arr.length
    while (lo <= hi) {
      val mid = (lo + hi) >> 1
      if (arr(mid) > target) {
        res = mid
        hi = mid - 1
      } else lo = mid + 1
    }
    res
  }
}
