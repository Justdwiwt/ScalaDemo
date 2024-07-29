package leetCode._3300

object Solution_3229 {
  def minimumOperations(nums: Array[Int], target: Array[Int]): Long = {
    val initialDiff = (target.head - nums.head).toLong
    val initialAns = initialDiff.abs

    nums.zip(target).zip(nums.tail.zip(target.tail))
      .foldLeft((initialDiff, initialAns)) { case ((s, ans), ((prevNum, prevTarget), (num, target))) =>
        val k = (target - prevTarget) - (num - prevNum)
        val kLong = k.toLong
        val newAns =
          if (k > 0) ans + (if (s >= 0) kLong else 0L.max(kLong + s))
          else ans - (if (s <= 0) kLong else 0L.min(kLong + s))
        (s + kLong, newAns)
      }._2
  }
}
