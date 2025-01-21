package leetCode._3500

object Solution_3423 {
  def maxAdjacentDistance(nums: Array[Int]): Int = {
    val extendedNums = nums :+ nums.head
    extendedNums.zip(extendedNums.tail).map { case (x, y) => (x - y).abs }.max
  }
}
