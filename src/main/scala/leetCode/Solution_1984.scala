package leetCode

object Solution_1984 {
  def minimumDifference(nums: Array[Int], k: Int): Int = nums
    .sorted
    .sliding(k)
    .map(w => w.last - w.head)
    .min
}
