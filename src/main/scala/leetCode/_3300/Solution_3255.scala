package leetCode._3300

object Solution_3255 {
  def resultsArray(nums: Array[Int], k: Int): Array[Int] = nums
    .tail
    .zipWithIndex
    .scanLeft(1) { case (cnt, (num, i)) => if (num - nums(i) == 1) cnt + 1 else 1 }
    .zipWithIndex
    .map { case (cnt, i) => if (i >= k - 1 && cnt >= k) nums(i) else -1 }
    .drop(k - 1)
}
