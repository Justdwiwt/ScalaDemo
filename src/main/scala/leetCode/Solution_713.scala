package leetCode

object Solution_713 {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    if (nums.isEmpty) 0
    else f(nums, 0, 0, nums(0), 0, k)
  }

  @scala.annotation.tailrec
  def f(nums: Array[Int], lIdx: Int, rIdx: Int, p: Int, cnt: Int, k: Int): Int = {
    if (rIdx == nums.length) cnt
    else {
      val (nLIdx, nRIdx) = g(nums, lIdx, rIdx, p, k)
      if (rIdx == nums.length - 1) f(nums, nLIdx, rIdx + 1, nRIdx, cnt + rIdx - nLIdx + 1, k)
      else f(nums, nLIdx, rIdx + 1, nRIdx * nums(rIdx + 1), cnt + rIdx - nLIdx + 1, k)
    }
  }

  @scala.annotation.tailrec
  def g(nums: Array[Int], lIdx: Int, rIdx: Int, p: Int, k: Int): (Int, Int) = {
    if (p >= k && lIdx < nums.length - 1) g(nums, lIdx + 1, rIdx, p / nums(lIdx), k)
    else (lIdx, p)
  }
}
