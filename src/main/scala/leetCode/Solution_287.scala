package leetCode

object Solution_287 {
  def findDuplicate(nums: Array[Int]): Int = nums
    .groupBy(identity)
    .mapValues(_.length)
    .filter(k => k._2 >= 2)
    .keys
    .head
}
