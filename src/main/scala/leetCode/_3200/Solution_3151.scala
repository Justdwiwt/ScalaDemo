package leetCode._3200

object Solution_3151 {
  def isArraySpecial(nums: Array[Int]): Boolean =
    nums.zip(nums.tail).forall { case (a, b) => (a % 2 != 0 && b % 2 == 0) || (a % 2 == 0 && b % 2 != 0) }
}
