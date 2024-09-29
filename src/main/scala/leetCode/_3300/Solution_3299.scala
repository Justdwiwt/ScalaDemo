package leetCode._3300

object Solution_3299 {
  def getSum(nums: Array[Int]): Int = {
    val mx = nums.max
    val M = 1000000007

    def computeDpArrays(nums: Array[Int], m: Int): (Array[Array[Long]], Array[Array[Long]]) = {
      val dpUp = Array.fill(m + 2, 2)(0L)
      val dpDown = Array.fill(m + 2, 2)(0L)

      nums.foreach(k => {
        dpUp(k)(0) = (dpUp(k).head + dpUp(k - 1).head + 1) % M
        dpUp(k)(1) = (dpUp(k)(1) + dpUp(k - 1)(1) + (dpUp(k - 1).head + 1) * k) % M
        dpDown(k)(0) = (dpDown(k).head + dpDown(k + 1).head + 1) % M
        dpDown(k)(1) = (dpDown(k)(1) + dpDown(k + 1)(1) + (dpDown(k + 1).head + 1) * k) % M
      })

      (dpUp, dpDown)
    }

    val (dpUp, dpDown) = computeDpArrays(nums, mx)

    val totalSum = (1 to mx).foldLeft(0L)((sum, i) => (sum + dpUp(i)(1) + dpDown(i)(1)) % M)

    ((totalSum - nums.map(_.toLong).sum % M) % M + M).toInt % M
  }
}
