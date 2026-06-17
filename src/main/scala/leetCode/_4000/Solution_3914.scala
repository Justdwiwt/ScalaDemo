package leetCode._4000

object Solution_3914 {
  def minOperations(nums: Array[Int]): Long =
    nums.zip(nums.tail).foldLeft(0L) {
      case (acc, (x, y)) => acc + 0.max(x - y)
    }
}
