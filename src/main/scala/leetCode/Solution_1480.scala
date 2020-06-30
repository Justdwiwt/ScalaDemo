package leetCode

object Solution_1480 {
  def runningSum(nums: Array[Int]): Array[Int] = {
    (1 until nums.length).foreach(i => nums(i) += nums(i - 1))
    nums
  }
}
