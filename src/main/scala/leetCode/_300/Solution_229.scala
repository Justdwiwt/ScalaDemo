package leetCode._300

object Solution_229 {
  def majorityElement(nums: Array[Int]): List[Int] = nums
    .zipWithIndex
    .groupBy(_._1)
    .mapValues(_.length)
    .filter(_._2 > nums.length / 3)
    .keys
    .toList
}
