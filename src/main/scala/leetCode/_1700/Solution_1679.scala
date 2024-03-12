package leetCode._1700

object Solution_1679 {
  @scala.annotation.tailrec
  def maxOperations(nums: Array[Int], k: Int, pos: Int = 0, m: Map[Int, Int] = Map.empty, count: Int = 0): Int =
    if (pos >= nums.length) count
    else nums(pos) match {
      case n => m.get(k - n) match {
        case None => maxOperations(nums, k, pos + 1, m + (n -> (m.getOrElse(n, 0) + 1)), count)
        case Some(1) => maxOperations(nums, k, pos + 1, m - (k - n), count + 1)
        case Some(o) => maxOperations(nums, k, pos + 1, m + ((k - n) -> (o - 1)), count + 1)
      }
    }
}
