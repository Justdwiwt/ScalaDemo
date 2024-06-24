package leetCode._3200

object Solution_3192 {
  def minOperations(nums: Array[Int]): Int =
    nums.foldLeft(0)((res, x) => if (x == res % 2) res + 1 else res)
}
