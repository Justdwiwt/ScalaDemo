package leetCode._1500

object Solution_1480 {
  def runningSum(nums: Array[Int]): Array[Int] =
    nums.scanLeft(0)(_ + _).tail
}
