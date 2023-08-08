package leetCode

object Solution_2811 {
  def canSplitArray(nums: List[Int], m: Int): Boolean =
    nums.size < 3 || nums.sliding(2).exists(_.sum >= m)
}
