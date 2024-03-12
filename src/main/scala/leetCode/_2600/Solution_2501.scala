package leetCode._2600

import scala.collection.mutable

object Solution_2501 {
  def longestSquareStreak(nums: Array[Int]): Int = {
    val m = mutable.Map.empty[Int, Int]
    nums.sortBy(ele => ele * -1)./:(-1)((totalCount, item) => {
      val updatedSeqCount = m.getOrElse(item * item, 0) + 1
      m.update(item, updatedSeqCount)
      totalCount.max(if (updatedSeqCount == 1) -1 else updatedSeqCount)
    })
  }
}
