package leetCode._3200

object Solution_3105 {
  def longestMonotonicSubarray(nums: Array[Int]): Int =
    f(nums).max(f(nums.reverse))

  private def f(nums: Array[Int]): Int =
    nums.tail.foldLeft((1, 1, nums.head)) { case ((len, max, prev), num) =>
      if (prev < num) (len + 1, math.max(max, len + 1), num) else (1, max, num)
    }._2
}
