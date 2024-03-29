package leetCode._1700

object Solution_1685 {
  def getSumAbsoluteDifferences(nums: Array[Int]): Array[Int] = {
    val prefixSum = nums.scanLeft(0L)(_ + _)
    val suffixSum = nums.scanRight(0L)(_ + _).tail
    nums.zipWithIndex.map { case (n, i) =>
      val before = n * i - prefixSum(i)
      val after = suffixSum(i) - n * (nums.length - i - 1)
      (before + after).toInt
    }
  }
}
