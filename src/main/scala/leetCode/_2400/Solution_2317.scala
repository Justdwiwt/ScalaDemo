package leetCode._2400

object Solution_2317 {
  def maximumXOR(nums: Array[Int]): Int =
    nums.reduce(_ | _)
}
