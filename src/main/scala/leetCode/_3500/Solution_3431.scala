package leetCode._3500

object Solution_3431 {
  def minUnlockedIndices(nums: Array[Int], locked: Array[Int]): Int = {
    val n = nums.length
    val (left3, right1, left2, right2) = nums.zipWithIndex.foldLeft((n, -1, n, -1)) {
      case ((l3, r1, l2, r2), (x, i)) => x match {
        case 3 => (l3.min(i), r1, l2, r2)
        case 1 => (l3, i, l2, r2)
        case 2 => (l3, r1, l2.min(i), i)
        case _ => (l3, r1, l2, r2)
      }
    }
    if (right1 > left3) return -1

    def sumUnlocked(rangeStart: Int, rangeEnd: Int): Int =
      if (rangeStart < rangeEnd) locked.slice(rangeStart, rangeEnd).sum else 0

    sumUnlocked(left3, right2) + sumUnlocked(left2, right1)
  }
}
