package leetCode._500

object Solution_442 {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    nums.groupBy(_ * 1).collect({ case x if x._2.length > 1 => x._1 }).toList
  }
}
