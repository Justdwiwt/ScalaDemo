package leetCode._2600

object Solution_2574 {
  def leftRigthDifference(nums: Array[Int]): Array[Int] = nums
    .scanLeft(0)(_ + _)
    .init
    .zip(nums.scanRight(0)(_ + _).tail)
    .map(n => (n._2 - n._1).abs)
}
