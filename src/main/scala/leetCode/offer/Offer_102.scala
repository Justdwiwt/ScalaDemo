package leetCode.offer

object Offer_102 {
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    def f(nums: Array[Int], start: Int, S: Int): Int = {
      if (start == nums.length) return if (S == 0) 1 else 0
      f(nums, start + 1, S + nums(start)) + f(nums, start + 1, S - nums(start))
    }

    f(nums, 0, S)
  }
}
