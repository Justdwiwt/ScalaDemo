package leetCode._3400

object Solution_3379 {
  def constructTransformedArray(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    nums.zipWithIndex.map { case (x, i) => nums(((i + x) % n + n) % n) }
  }
}
