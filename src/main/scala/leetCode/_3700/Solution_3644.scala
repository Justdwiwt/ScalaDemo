package leetCode._3700

object Solution_3644 {
  def sortPermutation(nums: Array[Int]): Int =
    if (nums(0) != 0) 0
    else 0.max(nums.indices.foldLeft(-1)((a, i) => if (nums(i) != i) a & nums(i) else a))
}
