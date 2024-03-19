package leetCode._2200

import scala.collection.mutable

object Solution_2163 {
  def minimumDifference(nums0: Array[Int]): Long = {
    val nums = nums0.map(_.toLong)
    val n = nums.length / 3

    val lowestN = mutable.PriorityQueue(nums.take(n): _*)
    val prefixLowest = (n until 2 * n).scanLeft(lowestN.sum) { case (sum, idx) =>
      val prevHighest = lowestN.dequeue
      val newLowest = prevHighest.min(nums(idx))
      lowestN.enqueue(newLowest)
      sum - prevHighest + newLowest
    }

    val highestN = mutable.PriorityQueue(nums.takeRight(n): _*)(Ordering.by(-_))
    val suffixHighest = (n until 2 * n).scanRight(highestN.sum) { case (idx, sum) =>
      val prevLowest = highestN.dequeue
      val newHighest = prevLowest.max(nums(idx))
      highestN.enqueue(newHighest)
      sum - prevLowest + newHighest
    }

    prefixLowest.zip(suffixHighest).map { case (l, h) => l - h }.min
  }
}
