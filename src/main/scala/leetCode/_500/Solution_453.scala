package leetCode._500

object Solution_453 {
  def minMoves(nums: Array[Int]): Int = {
    nums.sum - nums.min * nums.length
  }
}
