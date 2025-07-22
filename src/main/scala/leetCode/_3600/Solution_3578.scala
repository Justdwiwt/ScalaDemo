package leetCode._3600

import scala.collection.mutable

object Solution_3578 {
  def countPartitions(nums: Array[Int], k: Int): Int = {
    val M = 1000000007
    val n = nums.length
    val dp = Array.fill(n + 1)(0L)
    val preSum = Array.fill(n + 2)(0L)
    dp(0) = 1
    preSum(1) = 1

    var left = 0

    val minQ = new MonotonicDeque(isMin = true)
    val maxQ = new MonotonicDeque(isMin = false)

    nums.indices.foreach(right => {
      minQ.push(nums, right)
      maxQ.push(nums, right)

      while (maxQ.peek(nums) - minQ.peek(nums) > k) {
        left += 1
        if (minQ.frontIndex < left) minQ.popFront()
        if (maxQ.frontIndex < left) maxQ.popFront()
      }

      dp(right + 1) = (preSum(right + 1) - preSum(left) + M) % M
      preSum(right + 2) = (preSum(right + 1) + dp(right + 1)) % M
    })

    dp(n).toInt
  }

  private class MonotonicDeque(isMin: Boolean) {
    private val deque = mutable.ListBuffer.empty[Int]

    def push(nums: Array[Int], i: Int): Unit = {
      while (deque.nonEmpty &&
        (if (isMin) nums(deque.last) >= nums(i) else nums(deque.last) <= nums(i))) {
        deque.remove(deque.length - 1)
      }
      deque.append(i)
    }

    def peek(nums: Array[Int]): Int =
      nums(deque.head)

    def popFront(): Unit =
      if (deque.nonEmpty) deque.remove(0)

    def frontIndex: Int =
      if (deque.nonEmpty) deque.head else -1
  }
}
