package leetCode._2700

object Solution_2640 {
  def findPrefixScore(nums: Array[Int]): Array[Long] = nums
    .scanLeft(0L)(_.max(_))
    .tail
    .zip(nums)
    .map { case (max, num) => max + num }
    .scanLeft(0L)(_ + _)
    .tail
}
