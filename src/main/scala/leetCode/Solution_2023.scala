package leetCode

object Solution_2023 {
  def numOfPairs(nums: Array[String], target: String): Int = {
    var res = 0
    nums.indices.foreach(i => nums.indices.withFilter(j => j != i && nums(i) + nums(j) == target).foreach(_ => res += 1))
    res
  }
}
