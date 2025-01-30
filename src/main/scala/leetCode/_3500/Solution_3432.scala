package leetCode._3500

object Solution_3432 {
  def countPartitions(nums: Array[Int]): Int = nums.sum % 2 match {
    case 0 => nums.length - 1
    case _ => 0
  }
}
