package leetCode._2800

object Solution_2740 {
  def findValueOfPartition(nums: Array[Int]): Int = nums
    .sorted
    .sliding(2)
    .map { case Array(a, b) => (a - b).abs }
    .min
}
