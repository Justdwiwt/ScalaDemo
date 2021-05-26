package leetCode

object Solution_1863 {
  def subsetXORSum(nums: Array[Int]): Int =
    nums.reduce(_ | _) * math.pow(2, nums.length - 1).toInt
}
