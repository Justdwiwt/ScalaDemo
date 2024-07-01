package leetCode._3300

object Solution_3201 {
  def maximumLength(nums: Array[Int]): Int = {
    val oddCount = nums.count(_ % 2 != 0)
    val lenNums = nums.length
    val oddPairsCount = nums.sliding(2).count {
      case Array(x, y) => (x % 2) != (y % 2)
      case _ => false
    }

    Array(oddCount, lenNums - oddCount, 1 + oddPairsCount).max
  }
}
