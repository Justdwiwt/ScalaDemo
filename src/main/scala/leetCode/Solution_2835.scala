package leetCode

import scala.collection.immutable.TreeMap

object Solution_2835 {
  implicit class TreeMapQueue[K](val counts: TreeMap[K, Int]) extends AnyVal {
    def dequeue: (K, TreeMap[K, Int]) = deq(counts.head)

    def enqueue(k: K): TreeMap[K, Int] = counts.updated(k, counts.getOrElse(k, 0) + 1)

    private def deq(entry: (K, Int)): (K, TreeMap[K, Int]) = {
      val (k, v) = entry
      if (v <= 1) (k, counts.drop(counts(k)))
      else (k, counts.updated(k, v - 1))
    }
  }

  private val empty = TreeMap.empty[Int, Int](Ordering[Int].reverse)

  def minOperations(nums: List[Int], target: Int): Int = {
    val sum = nums./:(0L)(_ + _)
    val queue = nums./:(empty)(_.enqueue(_))
    if (sum < target) -1 else count(sum, target, queue, 0)
  }

  @scala.annotation.tailrec
  private def count(sum: Long, target: Int, queue: TreeMap[Int, Int], cnt: Int): Int =
    if (target <= 0) cnt
    else {
      val (head, tail) = queue.dequeue
      if (sum - head >= target) count(sum - head, target, tail, cnt)
      else if (head <= target) count(sum - head, target - head, tail, cnt)
      else count(sum, target, tail.enqueue(head / 2).enqueue(head / 2), cnt + 1)
    }
}
