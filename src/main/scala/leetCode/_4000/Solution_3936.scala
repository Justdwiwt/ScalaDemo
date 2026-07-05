package leetCode._4000

object Solution_3936 {
  def minimumSwaps(nums: Array[Int]): Int = {
    val zeros = nums.count(_ == 0)
    nums.takeRight(zeros).count(_ != 0)
  }
}
