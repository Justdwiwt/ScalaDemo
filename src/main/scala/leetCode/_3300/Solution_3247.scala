package leetCode._3300

object Solution_3247 {
  def subsequenceCount(nums: Array[Int]): Int = {
    val M = 1000000007

    val (odd, _) = nums.foldLeft((0L, 1L)) {
      case ((odd, even), num) =>
        if (num % 2 == 0) ((odd * 2) % M, (even * 2) % M)
        else {
          val newOdd = (even + odd) % M
          val newEven = (even + odd) % M
          (newOdd, newEven)
        }
    }

    odd.toInt
  }
}
