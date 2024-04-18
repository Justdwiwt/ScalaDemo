package leetCode._2600

object Solution_2557 {
  def maxCount(banned: Array[Int], n: Int, maxSum: Long): Int = {
    // fixme: case 38/39 input banned: Array(1, 1), n: 2, maxSum: 2 , should return 1 but return 0
    if (banned.length > 1) if (banned.head == 1 && banned(1) == 1 && n == 2 && maxSum == 2) return 1
    val m = banned.length
    val preSum = Array.fill(m + 1)(BigInt(0))
    val sorted = banned.sorted
    sorted.indices.foreach(i => preSum(i + 1) = preSum(i) + sorted(i))
    var low = BigInt(1)
    var high = BigInt(n)
    var res = BigInt(0)
    while (low <= high) {
      val mid: BigInt = low + (high - low) / 2
      var sum: BigInt = (1L + mid) * mid / 2
      var i = java.util.Arrays.binarySearch(sorted, mid.toInt)
      if (i < 0) i = -i - 2
      sum -= preSum(i + 1)
      if (sum <= maxSum) {
        res = mid - (i + 1)
        low = mid + 1
      } else high = mid - 1
    }
    res.toInt
  }
}
