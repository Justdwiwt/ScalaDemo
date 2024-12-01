package leetCode._3400

object Solution_3364 {
  def minimumSumSubarray(nums: List[Int], l: Int, r: Int): Int = {
    val preSum = nums.scanLeft(0)(_ + _)
    util.Try((l to r)
        .flatMap(i => preSum.zip(preSum.drop(i)).map(n => n._2 - n._1))
        .filter(_ > 0).min)
      .getOrElse(-1)
  }
}
