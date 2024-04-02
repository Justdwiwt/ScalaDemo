package leetCode._800

object Solution_713 {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(lo: Int, hi: Int, prod: Int, acc: Int): Int = {
      lazy val inc = if (prod >= k) 0 else hi - lo
      if (hi >= nums.length && prod < k) acc + inc
      else if (lo >= nums.length) acc
      else if (lo >= hi) f(hi, hi + 1, nums(hi), acc)
      else if (prod >= k) f(lo + 1, hi, prod / nums(lo), acc)
      else f(lo, hi + 1, prod * nums(hi), acc + inc)
    }

    f(0, 0, 0, 0)
  }
}
