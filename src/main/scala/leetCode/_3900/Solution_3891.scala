package leetCode._3900

object Solution_3891 {
  def minIncrease(nums: Array[Int]): Long = {
    val n = nums.length

    def cost(i: Int): Long = 0.max(nums(i - 1).max(nums(i + 1)) - nums(i) + 1).toLong

    val suf0 = (n - 2 to 1 by -2).iterator.map(cost).sum

    if ((n & 1) == 1) suf0
    else (1 until n - 1 by 2).foldLeft((0L, suf0, suf0)) {
        case ((pre, suf, ans), i) =>
          val p = pre + cost(i)
          val s = suf - (if (i + 2 < n) cost(i + 1) else 0L)
          (p, s, ans.min(p + s))
      }
      ._3
  }
}
