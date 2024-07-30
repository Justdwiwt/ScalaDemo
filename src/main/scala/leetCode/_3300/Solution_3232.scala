package leetCode._3300

object Solution_3232 {
  def canAliceWin(nums: Array[Int]): Boolean =
    nums.partition(_ > 9) match {
      case (sd, dd) => sd.sum != dd.sum
    }
}
