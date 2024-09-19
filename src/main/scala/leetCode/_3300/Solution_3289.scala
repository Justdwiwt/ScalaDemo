package leetCode._3300

object Solution_3289 {
  def getSneakyNumbers(nums: Array[Int]): Array[Int] = nums
    .groupBy(identity)
    .collect { case (num, occurrences) if occurrences.length > 1 && num < nums.length - 2 => num }
    .toArray
}
