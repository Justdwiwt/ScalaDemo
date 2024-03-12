package leetCode._1500

object Solution_1464 {
  def maxProduct(nums: Array[Int]): Int = {
    nums.map(_.abs - 1).sortBy(-_).take(2).product
  }
}
