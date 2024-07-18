package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_17_20 {
  class MedianFinder {
    private val maxHeap = mutable.PriorityQueue.empty[Int](Ordering.Int.reverse)
    private val minHeap = mutable.PriorityQueue.empty[Int]

    def addNum(num: Int): Unit =
      if (maxHeap.size > minHeap.size) {
        maxHeap.enqueue(num)
        minHeap.enqueue(maxHeap.dequeue())
      } else {
        minHeap.enqueue(num)
        maxHeap.enqueue(minHeap.dequeue())
      }

    def findMedian(): Double =
      if (maxHeap.size > minHeap.size) maxHeap.head.toDouble
      else if (minHeap.size > maxHeap.size) minHeap.head.toDouble
      else (maxHeap.head + minHeap.head) / 2.0
  }
}
