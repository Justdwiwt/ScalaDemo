package leetCode._4000

object Solution_3982 {
  def maxDigitRange(nums: Array[Int]): Int = {
    val n = nums.map(num => num.toString.map(_.asDigit).max - num.toString.map(_.asDigit).min).max
    nums.filter(num => num.toString.map(_.asDigit).max - num.toString.map(_.asDigit).min == n).sum
  }
}
