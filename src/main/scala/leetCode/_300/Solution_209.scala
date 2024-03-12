package leetCode._300

object Solution_209 {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {

    @annotation.tailrec
    def func(left: Int, hi: Int, sum: Int, mn: Int): Int =
      if (hi >= nums.length) {
        if (left < nums.length && sum - nums(left) >= s) func(left + 1, hi, sum - nums(left), mn.min(hi - left))
        else if (mn != Int.MaxValue || sum >= s) mn.min(hi - left)
        else 0
      }
      else if (sum < s) func(left, hi + 1, sum + nums(hi), mn)
      else func(left + 1, hi, sum - nums(left), mn.min(hi - left))

    func(0, 0, 0, Int.MaxValue)
  }
}
