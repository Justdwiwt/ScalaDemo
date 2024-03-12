package leetCode._2600

object Solution_2535 {
  def differenceOfSum(nums: Array[Int]): Int =
    nums.sum - nums.map(n => n.toString.map(_ - '0').sum).sum
}
