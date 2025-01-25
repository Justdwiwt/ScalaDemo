package leetCode._3500

object Solution_3427 {
  def subarraySum(nums: Array[Int]): Int =
    nums.indices.foldLeft(0)((total, i) => (0.max(i - nums(i)) to i).foldLeft(total)((acc, j) => acc + nums(j)))
}
