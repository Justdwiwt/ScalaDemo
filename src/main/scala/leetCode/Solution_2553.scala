package leetCode

object Solution_2553 {
  def separateDigits(nums: Array[Int]): Array[Int] =
    nums.flatMap(_.toString.map(_ - '0'))
}
