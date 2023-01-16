package leetCode

object Solution_2535 {
  def differenceOfSum(nums: Array[Int]): Int = {
    val digits = nums.flatMap(_.toString).map(_ - '0')
    (nums.sum - digits.sum).abs
  }
}
