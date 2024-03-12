package leetCode._2800

object Solution_2740 {
  def findValueOfPartition(nums: Array[Int]): Int = nums
    .sorted
    .sliding(2)
    .map(n => n(1) - n.head)
    .min
}
