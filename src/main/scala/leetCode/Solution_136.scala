package leetCode

object Solution_136 {
  def singleNumber(nums: Array[Int]): Int = {
    nums.fold(0)(_ ^ _)
  }
}
