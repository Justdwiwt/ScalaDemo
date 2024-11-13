package leetCode._3400

object Solution_3349 {
  def hasIncreasingSubarrays(nums: List[Int], k: Int): Boolean = {
    val n = nums.length

    def check(idx: Int): Boolean =
      (1 until k).forall(i => nums(idx + i) > nums(idx + i - 1))

    (0 to n - 2 * k).exists(i => check(i) && check(i + k))
  }
}
