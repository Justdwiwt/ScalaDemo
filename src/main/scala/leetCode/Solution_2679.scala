package leetCode

object Solution_2679 {
  def matrixSum(nums: Array[Array[Int]]): Int = nums
    .map(_.sorted)
    .transpose
    .map(_.max)
    .sum
}
