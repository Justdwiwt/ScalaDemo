package leetCode._2800

object Solution_2747 {
  def countServers(n: Int, logs: Array[Array[Int]], x: Int, queries: Array[Int]): Array[Int] = {
    val arr = queries.indices.toArray
    val sortedId = arr.sortBy(queries)

    val sortedLogs = logs.sortBy(_(1))

    val ans = Array.ofDim[Int](queries.length)
    val cnt = Array.ofDim[Int](n + 1)
    var outOfRange = n
    var left = 0
    var right = 0

    sortedId.foreach(i => {
      while (right < sortedLogs.length && sortedLogs(right)(1) <= queries(i)) {
        if (cnt(sortedLogs(right).head) == 0) outOfRange -= 1
        cnt(sortedLogs(right).head) += 1
        right += 1
      }
      while (left < sortedLogs.length && sortedLogs(left)(1) < queries(i) - x) {
        if (cnt(sortedLogs(left).head) == 1) outOfRange += 1
        cnt(sortedLogs(left).head) -= 1
        left += 1
      }
      ans(i) = outOfRange
    })
    ans
  }
}
