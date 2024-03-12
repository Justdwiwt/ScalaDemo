package leetCode._3100

import scala.collection.mutable

object Solution_3026 {
  def maximumSubarraySum(nums: Array[Int], k: Int): Long = {
    var prefSum = 0L
    var maxGoodSum = Long.MinValue
    val minPrefSum = mutable.HashMap[Long, Long]().withDefaultValue(Long.MaxValue)

    nums.foreach(x => {
      prefSum += x
      minPrefSum(x) = minPrefSum(x).min(prefSum)

      maxGoodSum = (Seq(x + k, x - k).collect { case seek if minPrefSum.contains(seek) =>
        prefSum - minPrefSum(seek) + seek
      } :+ maxGoodSum).max
    })

    if (maxGoodSum == Long.MinValue) 0 else maxGoodSum
  }
}
