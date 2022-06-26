package leetCode

object Solution_2302 {
  def countSubarrays(nums: Array[Int], k: Long): Long = {
    @scala.annotation.tailrec
    def f(left: Int, right: Int, sum: Long, cnt: Long): Long =
      if (right == nums.length) cnt
      else {
        val (newSum, newLeft) = Iterator
          .iterate((sum + nums(right), left)) { case (sum, left) => (sum - nums(left), left + 1) }
          .dropWhile { case (sum, left) => sum * (right - left + 1) >= k }
          .next()
        f(newLeft, right + 1, newSum, cnt + (right - newLeft + 1))
      }

    f(left = 0, right = 0, sum = 0, cnt = 0)
  }
}
