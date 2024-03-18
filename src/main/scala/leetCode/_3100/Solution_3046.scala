package leetCode._3100

object Solution_3046 {
  def isPossibleToSplit(nums: Array[Int]): Boolean = nums
    .groupBy(identity)
    .forall(_._2.length < 3)
}
