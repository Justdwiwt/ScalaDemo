package leetCode._3000

object Solution_2903 {
  def findIndices(nums: Array[Int], indexDifference: Int, valueDifference: Int): Array[Int] = scala
    .util
    .Try(nums.indices.flatMap(i => (i + indexDifference until nums.length)
      .withFilter(j => (nums(j) - nums(i)).abs >= valueDifference)
      .map(j => Array(i, j)))
      .head)
    .getOrElse(Array(-1, -1))
}
