package leetCode._3900

object Solution_3804 {
  def centeredSubarrays(nums: Array[Int]): Int = {
    val n = nums.length

    nums
      .indices
      .map(i => (i until n).foldLeft((0, Set.empty[Int], 0)) { case ((sum, seen, count), j) =>
          val newSum = sum + nums(j)
          val newSeen = seen + nums(j)
          val newCount = if (newSeen.contains(newSum)) count + 1 else count
          (newSum, newSeen, newCount)
        }
        ._3)
      .sum
  }
}
