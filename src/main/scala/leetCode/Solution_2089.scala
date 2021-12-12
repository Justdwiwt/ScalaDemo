package leetCode

object Solution_2089 {
  def targetIndices(nums: Array[Int], target: Int): List[Int] = nums
    .sorted
    .zipWithIndex
    .collect({ case (n, i) if n == target => i })
    .toList
}
