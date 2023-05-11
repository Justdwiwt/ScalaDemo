package leetCode

object Solution_2659 {
  def countOperationsToEmptyArray(nums: Array[Int]): Long = {
    val sorted = nums.indices.sortBy(nums(_))
    val sum = nums.indices.drop(1).collect { case i if sorted(i) < sorted(i - 1) => (nums.length - i).toLong }.sum
    sum + nums.length
  }
}
