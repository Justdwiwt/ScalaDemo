package leetCode._3600

import scala.collection.mutable

object Solution_3505 {
  def minOperations(nums: Array[Int], x: Int, k: Int): Long = {
    val n = nums.length
    if (n < k.toLong * x) return -1L

    val INF: BigInt = BigInt("281474976710655")

    val lower = mutable.PriorityQueue[Int]()
    val upper = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)
    var lowerSum = BigInt(0)
    var upperSum = BigInt(0)
    var lowerSize = 0
    var upperSize = 0
    val delayed = mutable.HashMap[Int, Int]()

    def adjustHeaps(): Unit = {
      while (lower.nonEmpty && delayed.getOrElse(lower.head, 0) > 0) {
        val top = lower.dequeue()
        delayed(top) = delayed(top) - 1
        if (delayed(top) == 0) delayed.remove(top)
      }
      while (upper.nonEmpty && delayed.getOrElse(upper.head, 0) > 0) {
        val top = upper.dequeue()
        delayed(top) = delayed(top) - 1
        if (delayed(top) == 0) delayed.remove(top)
      }
      if (lowerSize > upperSize + 1) {
        val moved = lower.dequeue()
        lowerSum -= moved
        lowerSize -= 1
        upper.enqueue(moved)
        upperSum += moved
        upperSize += 1
      } else if (lowerSize < upperSize) {
        val moved = upper.dequeue()
        upperSum -= moved
        upperSize -= 1
        lower.enqueue(moved)
        lowerSum += moved
        lowerSize += 1
      }
    }

    def addNum(num: Int): Unit = {
      if (lower.isEmpty || num <= lower.head) {
        lower.enqueue(num)
        lowerSum += num
        lowerSize += 1
      } else {
        upper.enqueue(num)
        upperSum += num
        upperSize += 1
      }
      adjustHeaps()
    }

    def removeNum(num: Int): Unit = {
      delayed(num) = delayed.getOrElse(num, 0) + 1
      if (lower.nonEmpty && num <= lower.head) {
        lowerSum -= num
        lowerSize -= 1
      } else {
        upperSum -= num
        upperSize -= 1
      }
      adjustHeaps()
    }

    def median: Int = if (lower.nonEmpty) lower.head else 0

    def currentCost(): BigInt = {
      val med = median
      BigInt(med) * lowerSize - lowerSum + upperSum - BigInt(med) * upperSize
    }

    val ch = Array.fill[BigInt](n)(INF)
    (0 until x).foreach(i => addNum(nums(i)))
    ch(x - 1) = currentCost()

    (x until n).foreach(r => {
      removeNum(nums(r - x))
      addNum(nums(r))
      ch(r) = currentCost()
    })

    val dp = Array.fill[BigInt](n)(INF)
    ((x - 1) until n).foreach(j => dp(j) = ch(j))
    ((x - 1) + 1 until n).foreach(j => dp(j) = dp(j).min(dp(j - 1)))

    var lmn = dp.clone()
    (2 to k).foreach(seg => {
      val startIdx = seg * x - 1
      val nxt = Array.fill[BigInt](n)(INF)
      if (startIdx < n) {
        nxt(startIdx) = lmn(startIdx - x) + ch(startIdx)
        ((startIdx + 1) until n).foreach(j => nxt(j) = nxt(j - 1).min(lmn(j - x) + ch(j)))
        (startIdx + 1 until n).foreach(j => nxt(j) = nxt(j).min(nxt(j - 1)))
      }
      lmn = nxt
    })

    val res = lmn(n - 1)
    if (res >= INF) -1L else res.toLong
  }
}
