package leetCode._3800

object Solution_3701 {
  def alternatingSum(nums: Array[Int]): Int =
    nums.foldRight(0)(_ - _)
}
