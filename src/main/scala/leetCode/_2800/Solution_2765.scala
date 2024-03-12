package leetCode._2800

object Solution_2765 {
  def alternatingSubarray(nums: Array[Int]): Int = {
    val n = nums.length

    @scala.annotation.tailrec
    def f(res: Int, i: Int, j: Int): Int = {
      if (i == n) return res
      if (j < n && nums(j) == (nums(i) + (j - i) % 2)) f(res.max(j - i + 1), i, j + 1)
      else f(res, i + 1, i + 2)
    }

    val res = f(0, 0, 1)
    if (res > 1) res else -1
  }
}
