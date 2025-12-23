package leetCode._3700

object Solution_3659 {
  def partitionArray(nums: Array[Int], k: Int): Boolean = {
    val n = nums.length
    if (n % k != 0) false
    else {
      val mx = nums.groupBy(identity).values.map(_.length).max
      mx.toLong * k <= n
    }
  }
}
