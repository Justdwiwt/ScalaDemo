package leetCode._3600

object Solution_3584 {
  def maximumProduct(nums: Array[Int], m: Int): Long = nums
    .zipWithIndex
    .drop(m - 1)
    .foldLeft((Int.MaxValue, Int.MinValue, Long.MinValue)) {
      case ((mn, mx, res), (x, i)) =>
        val y = nums(i - m + 1)
        val newMn = mn.min(y)
        val newMx = mx.max(y)
        val prod1 = x.toLong * newMn
        val prod2 = x.toLong * newMx
        val newRes = res.max(prod1.max(prod2))
        (newMn, newMx, newRes)
    }
    ._3
}
