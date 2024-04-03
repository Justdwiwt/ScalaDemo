package leetCode._700

object Solution_645 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val set = nums.toSet
    val missing = (1 to nums.length).find(!set.contains(_)).get
    Array(nums.sum - (1 to nums.length).sum + missing, missing)
  }
}
