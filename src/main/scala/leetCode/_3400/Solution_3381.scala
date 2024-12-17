package leetCode._3400

object Solution_3381 {
  def maxSubarraySum(nums: Array[Int], k: Int): Long = nums
    .iterator
    .scanLeft(0L)(_ + _)
    .toList
    .zipWithIndex
    .groupBy(_._2 % k)
    .mapValues(_.map(_._1))
    .values
    .filter(_.size > 1)
    .flatMap(l => l.drop(1).scanLeft((Long.MinValue, l.head)) { case ((mx, mn), x) =>
        (mx.max(x - mn), x.min(mn))
      }
      .drop(1)
      .map(_._1))
    .max
}
