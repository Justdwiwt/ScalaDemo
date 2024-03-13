package leetCode._3000

object Solution_2971 {
  def largestPerimeter(nums: Array[Int]): Long = {
    val sorted = nums.sorted
    val pSum = sorted.scanLeft(0L)(_ + _)
    sorted.indices.drop(2).reverse
      .collectFirst { case i if sorted(i) < pSum(i) => pSum(i) + sorted(i) }
      .getOrElse(-1L)
  }
}
