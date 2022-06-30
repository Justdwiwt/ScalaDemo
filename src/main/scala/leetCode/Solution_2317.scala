package leetCode

object Solution_2317 {
  def maximumXOR(nums: Array[Int]): Int =
    nums.reduce(_ | _)
}
