package leetCode._3800

object Solution_3736 {
  def minMoves(nums: Array[Int]): Int =
    nums.map(nums.max - _).sum
}
