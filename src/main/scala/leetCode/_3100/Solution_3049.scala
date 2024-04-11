package leetCode._3100

import scala.collection.mutable

object Solution_3049 {
  def earliestSecondToMarkIndices(nums: Array[Int], changeIndices: Array[Int]): Int = {
    val n = nums.length
    val m = changeIndices.length
    if (n > m) return -1

    val firstSeconds = Array.fill(n)(-1)
    changeIndices.indices.foreach(i => {
      val index = changeIndices(i) - 1
      if (firstSeconds(index) < 0) firstSeconds(index) = i
    })

    val originalTotal = n.toLong + nums.map(_.toLong).sum
    var low = n
    var high = m + 1

    def canMarkAll(maxSeconds: Int): Boolean = {
      var total = originalTotal
      var available = 0
      val pq = mutable.PriorityQueue.empty[Int].reverse

      (maxSeconds - 1 to 0 by -1).foreach(i => {
        val index = changeIndices(i) - 1
        available += 1

        if (i == firstSeconds(index) && nums(index) > 1) {
          pq.enqueue(nums(index) + 1)
          total -= nums(index) + 1
          available -= 2

          if (available < 0) {
            total += pq.dequeue()
            available += 2
          }
        }
      })

      available >= total
    }

    while (low < high) {
      val mid = (low + high) >>> 1
      if (canMarkAll(mid)) high = mid
      else low = mid + 1
    }

    if (low <= m) low else -1
  }
}
