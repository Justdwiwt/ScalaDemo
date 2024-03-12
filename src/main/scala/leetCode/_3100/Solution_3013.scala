package leetCode._3100

import scala.collection.mutable

object Solution_3013 {
  var k = 0
  private val lower = mutable.PriorityQueue.empty[Array[Int]]((a: Array[Int], b: Array[Int]) => b.head - a.head)
  private val higher = mutable.PriorityQueue.empty[Array[Int]]((a: Array[Int], b: Array[Int]) => a.head - b.head)
  private var lowerSize = 0
  private var higherSize = 0
  private val lowerSt = mutable.HashSet.empty[Int]
  private val higherSt = mutable.HashSet.empty[Int]
  private val removeSt = mutable.HashSet.empty[Int]
  private var totalCost = 0L

  def minimumCost(nums: Array[Int], K: Int, dist: Int): Long = {
    k = K
    totalCost = nums.head
    val n = nums.length
    (1 to (dist + 1)).foreach(i => add(nums(i), i))
    var minCost = totalCost
    (dist + 2 until n).foreach(i => {
      remove(nums(i - dist - 1), i - dist - 1)
      add(nums(i), 1)
      minCost = minCost.min(totalCost)
    })
    minCost
  }

  private def add(num: Int, idx: Int): Unit = {
    if (lowerSize < k - 1 || num <= lower.head.head) {
      lower += Array(num, idx)
      lowerSt += idx
      lowerSize += 1
      totalCost += num
    } else {
      higher += Array(num, idx)
      higherSt += idx
      higherSize += 1
    }
    adjustPriorityQueues()
  }

  private def remove(num: Int, idx: Int): Unit = {
    removeSt += idx
    if (lowerSt.contains(idx)) {
      lowerSize -= 1
      totalCost -= num
    } else higherSize -= 1
    adjustPriorityQueues()
  }

  private def adjustPriorityQueues(): Unit = {
    if (lowerSize > k - 1) {
      val arr = lower.head
      lower.dequeue()
      higher += arr
      lowerSize -= 1
      higherSize += 1
      totalCost -= arr.head
      lowerSt.remove(arr(1))
      higherSt += arr(1)
    } else if (lowerSize < k - 1 && higherSize > 0) {
      val arr = higher.head
      higher.dequeue()
      lower += arr
      lowerSize += 1
      higherSize -= 1
      totalCost += arr.head
      lowerSt += arr(1)
      higherSt.remove(arr(1))
    }
    Array(lower, higher).foreach(pq => {
      while (pq.nonEmpty && removeSt.contains(pq.head(1))) {
        val arr = pq.head
        pq.dequeue()
        removeSt.remove(arr(1))
      }
    })
  }
}
