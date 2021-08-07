package leetCode

object Solution_1955 {
  private val M = 1000000007

  def countSpecialSubsequences(nums: Array[Int]): Int = nums./:(0, 0, 0) {
    case ((zero, one, two), 0) => ((2 * zero % M + 1) % M, one, two)
    case ((zero, one, two), 1) => (zero, (2 * one % M + zero) % M, two)
    case ((zero, one, two), 2) => (zero, one, (2 * two % M + one) % M)
    case _ => throw new IllegalArgumentException(nums.mkString("Array(", ", ", ")"))
  }._3
}
