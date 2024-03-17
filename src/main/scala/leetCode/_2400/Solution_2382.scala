package leetCode._2400

import scala.collection.mutable

object Solution_2382 {
  def maximumSegmentSum(nums: Array[Int], removeQueries: Array[Int]): Array[Long] = {
    val m = mutable.Map.empty[Int, (Long, Int)].withDefaultValue((0L, 0))

    removeQueries.tail.scanRight(0L)((idx, pre) => {
      m.update(idx, (nums(idx).toLong, 1))

      val (rSum, rLen) = m(idx + 1)
      val (lSum, lLen) = m(idx - 1)

      val total = nums(idx) + rSum + lSum
      m.update(idx + rLen, (total, lLen + rLen + 1))
      m.update(idx - lLen, (total, lLen + rLen + 1))

      pre.max(total)
    })
  }
}
