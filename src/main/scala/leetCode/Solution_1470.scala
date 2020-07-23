package leetCode

object Solution_1470 {
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    (0 until n).flatMap(i => Array(nums(i), nums(i + n))).toArray
  }
}
