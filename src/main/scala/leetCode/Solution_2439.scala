package leetCode

object Solution_2439 {
  def minimizeArrayValue(nums: Array[Int]): Int =
    f(nums.toList, 0, 0, 0)

  @scala.annotation.tailrec
  def f(nums: List[Int], maxHeight: Long, sum: Long, width: Int): Int = nums match {
    case Nil => maxHeight.toInt
    case num :: tail =>
      val nSum = sum + num
      val nWidth = width + 1
      val nHeight = nSum / nWidth + (if (nSum % nWidth > 0) 1 else 0)
      f(tail, maxHeight.max(nHeight), nSum, nWidth)
  }
}
