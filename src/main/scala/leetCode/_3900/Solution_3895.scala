package leetCode._3900

object Solution_3895 {
  def countDigitOccurrences(nums: Array[Int], digit: Int): Int = nums
    .map(_.toString.map(_ - '0').count(_ == digit))
    .sum
}
