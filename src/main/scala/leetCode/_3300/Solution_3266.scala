package leetCode._3300

import scala.collection.mutable

object Solution_3266 {
  private val M = 1e9.toInt + 7

  private case class Node(index: Int, var value: Long)

  private def power(a: Long, b: Long): Long = {
    @scala.annotation.tailrec
    def powRec(a: Long, b: Long, res: Long): Long =
      if (b == 0) res
      else if (b % 2 == 1) powRec(a * a % M, b / 2, res * a % M)
      else powRec(a * a % M, b / 2, res)

    powRec(a, b, 1L)
  }

  def getFinalState(nums: Array[Int], k: Int, multiplier: Int): Array[Int] = {

    if (multiplier == 1) return nums

    val n = nums.length
    val res = Array.fill(n)(0)

    implicit val nodeOrdering: Ordering[Node] =
      Ordering.fromLessThan[Node]((a, b) => if (a.value != b.value) a.value < b.value else a.index < b.index)

    val pq = mutable.PriorityQueue.empty[Node](nodeOrdering.reverse)
    var maxVal = 0L

    nums.zipWithIndex.foreach { case (num, idx) =>
      maxVal = maxVal.max(num.toLong)
      pq.enqueue(Node(idx, num.toLong))
    }

    var remainingK = k

    while (remainingK > 0 && pq.head.value * multiplier <= maxVal) {
      remainingK -= 1
      val node = pq.dequeue()
      node.value = node.value * multiplier % M
      pq.enqueue(node)
    }

    val powerMultiplier = power(multiplier, remainingK / n)
    var kRem = remainingK % n

    while (pq.nonEmpty) {
      val node = pq.dequeue()
      if (remainingK / n > 0) node.value = node.value * powerMultiplier % M
      if (kRem > 0) {
        kRem -= 1
        node.value = node.value * multiplier % M
      }
      res(node.index) = node.value.toInt
    }

    res
  }
}
