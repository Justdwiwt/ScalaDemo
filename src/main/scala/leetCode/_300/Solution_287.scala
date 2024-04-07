package leetCode._300

object Solution_287 {
  def findDuplicate(nums: Array[Int]): Int = nums
    .groupBy(identity)
    .mapValues(_.length)
    .filter(_._2 >= 2)
    .keys
    .head
}
