package leetCode._4000

object Solution_3919 {
  def minCost(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = nums.length

    val sumL = nums
      .indices
      .drop(1)
      .scanLeft(0)((acc, i) => acc + (if (i < n - 1 && nums(i) - nums(i - 1) > nums(i + 1) - nums(i)) nums(i) - nums(i - 1) else 1))
      .toArray

    val sumR = nums
      .indices
      .drop(1)
      .scanLeft(0)((acc, i) => acc + (if (i > 1 && nums(i - 1) - nums(i - 2) <= nums(i) - nums(i - 1)) nums(i) - nums(i - 1) else 1))
      .toArray

    queries.map { case Array(l, r) => if (l < r) sumR(r) - sumR(l) else sumL(l) - sumL(r) }
  }
}
