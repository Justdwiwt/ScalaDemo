package leetCode._500

object Solution_485 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = nums
    .map(_.toString)
    .mkString
    .split("0")
    .map(_.length)
    .:+(0)
    .max
}
