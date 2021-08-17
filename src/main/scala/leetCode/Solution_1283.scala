package leetCode

object Solution_1283 {
  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    @scala.annotation.tailrec
    def f(st: Int, end: Int): Int =
      if (st == end) st
      else {
        val mid = st + (end - st) / 2
        val quotient = nums./:(0)((res, num) => res + (num * 1.0 / mid).ceil.toInt)
        if (quotient > threshold) f(mid + 1, end)
        else f(st, mid)
      }

    f(1, nums.max)
  }
}
