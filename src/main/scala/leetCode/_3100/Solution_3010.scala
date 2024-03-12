package leetCode._3100

object Solution_3010 {
  def minimumCost(nums: Array[Int]): Int =
    nums.tail.sorted.take(2).sum + nums.head
}
