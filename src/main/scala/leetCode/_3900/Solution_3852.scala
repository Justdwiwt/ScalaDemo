package leetCode._3900

object Solution_3852 {
  def minDistinctFreqPair(nums: Array[Int]): Array[Int] = {
    val pair = nums.groupBy(identity)
      .groupBy(_._2.length)
      .values
      .map(_.keys.min)
      .toArray
      .sorted
      .take(2)
    if (pair.length == 2) pair else Array(-1, -1)
  }
}
