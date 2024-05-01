package leetCode._1200

import scala.collection.mutable

object Solution_1167 {
  def connectSticks(sticks: Array[Int]): Int = {
    val minHeap = mutable.PriorityQueue.empty[Int](Ordering.Int.reverse) ++ sticks

    @scala.annotation.tailrec
    def f(heap: mutable.PriorityQueue[Int], acc: Int): Int =
      if (heap.size <= 1) acc
      else {
        val sum = heap.dequeue() + heap.dequeue()
        f(heap += sum, acc + sum)
      }

    f(minHeap, 0)
  }
}
