package leetCode._3300

object Solution_3264 {
  def getFinalState(nums: Array[Int], k: Int, multiplier: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(nums: Array[Int], k: Int): Array[Int] =
      if (k == 0) nums
      else {
        val (mnValue, mnIdx) = nums.zipWithIndex.minBy(_._1)
        val updated = nums.updated(mnIdx, mnValue * multiplier)
        f(updated, k - 1)
      }

    f(nums, k)
  }
}
