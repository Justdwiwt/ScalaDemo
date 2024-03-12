package leetCode._3000

object Solution_2913 {
  def sumCounts(nums: List[Int]): Int = nums
    .indices
    .flatMap(i => (i + 1 to nums.length).map(j => nums.slice(i, j).distinct.length))
    .map(x => x * x)
    .sum
}
