package leetCode._3800

object Solution_3788 {
  def maximumScore(nums: Array[Int]): Long = {
    val sum = nums.map(_.toLong).init.sum
    nums.init.foldRight((Long.MinValue, sum, nums.last)) {
      case (v, (max, sum, min)) =>
        (math.max(max, sum - min), sum - v, math.min(min, v))
    }._1
  }
}
