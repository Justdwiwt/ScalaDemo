package leetCode._3600

object Solution_3576 {
  def canMakeEqual(nums: Array[Int], k: Int): Boolean = {
    val (prev1, prev2, count1, count2) = nums.tail.foldLeft((nums.head, nums.head, 0, 0)) {
      case ((prev1, prev2, count1, count2), value) =>
        val (newPrev1, newCount1) =
          if (prev1 == -1) (-value, count1 + 1)
          else (value, count1)
        val (newPrev2, newCount2) =
          if (prev2 == 1) (-value, count2 + 1)
          else (value, count2)
        (newPrev1, newPrev2, newCount1, newCount2)
    }
    (count1 <= k && prev1 == 1) || (count2 <= k && prev2 == -1)
  }
}
