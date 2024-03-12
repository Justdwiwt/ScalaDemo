package leetCode._2100

object Solution_2099 {
  def maxSubsequence(nums: Array[Int], k: Int): Array[Int] = nums
    .zipWithIndex
    .sorted
    .reverse
    .take(k)
    .sortBy(_._2)
    .map(_._1)
}
