package leetCode._1300

object Solution_1295 {
  def findNumbers(nums: Array[Int]): Int =
    nums.count(_.toString.length % 2 == 0)
}
