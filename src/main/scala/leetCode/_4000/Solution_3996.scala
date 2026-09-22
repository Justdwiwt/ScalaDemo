package leetCode._4000

object Solution_3996 {
  def canReach(start: Array[Int], target: Array[Int]): Boolean =
    start.sum % 2 == target.sum % 2
}
