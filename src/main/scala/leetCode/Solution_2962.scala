package leetCode

object Solution_2962 {
  def countSubarrays(nums: Array[Int], k: Int): Long = {
    val m = nums.max
    val n = nums.length

    @scala.annotation.tailrec
    def f(i: Int, j: Int, cur: Int, res: Long, flag: Boolean): Long = {
      if (j == n) res
      else {
        val t = if (nums(j) == m && flag) cur + 1 else cur
        if (t >= k) f(i + 1, j, t - (if (nums(i) == m) 1 else 0), res, flag = false)
        else f(i, j + 1, t, res + i, flag = true)
      }
    }

    f(0, 0, 0, 0L, flag = true)
  }
}
