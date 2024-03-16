package leetCode._2500

object Solution_2441 {
  def findMaxK(nums: Array[Int]): Int =
    nums.foldLeft(-1)((res, n) => if (nums.contains(-n)) res.max(n) else res)
}
