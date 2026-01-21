package leetCode._3800

object Solution_3759 {
  def countElements(nums: Array[Int], k: Int): Int =
    if (k == 0) nums.length
    else {
      val sorted = nums.sorted
      val v = sorted(sorted.length - k)
      sorted.takeWhile(_ < v).length
    }
}
