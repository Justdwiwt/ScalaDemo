package leetCode._2200

object Solution_2178 {
  def maximumEvenSplit(finalSum: Long): List[Long] = {
    @scala.annotation.tailrec
    def f(nums: List[Long], sum: Long, next: Long): List[Long] =
      if (sum + next > finalSum) (finalSum - sum + nums.head) +: nums.tail
      else f(next +: nums, sum + next, next + 2)

    if (finalSum % 2 == 1) List.empty
    else f(List.empty, sum = 0, next = 2)
  }
}
