package leetCode._300

object Solution_229 {
  def majorityElement(nums: Array[Int]): List[Int] = nums
    .zipWithIndex
    .groupBy(v => v._1)
    .mapValues(v => v.length)
    .filter(v => v._2 > nums.length / 3)
    .keys.toList
}
