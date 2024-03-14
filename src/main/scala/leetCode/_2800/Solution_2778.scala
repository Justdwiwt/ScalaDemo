package leetCode._2800

object Solution_2778 {
  def sumOfSquares(nums: Array[Int]): Int = (1 to nums.length)
    .filter(nums.length % _ == 0)
    .map(n => nums(n - 1) * nums(n - 1))
    .sum
}
