package leetCode._2800

object Solution_2779 {
  def maximumBeauty(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var res, left = 0
    sorted.zipWithIndex.foreach { case (x, right) =>
      while (x - sorted(left) > k * 2) left += 1
      res = res.max(right - left + 1)
    }
    res
  }
}
