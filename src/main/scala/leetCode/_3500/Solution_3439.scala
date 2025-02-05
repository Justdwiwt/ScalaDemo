package leetCode._3500

object Solution_3439 {
  def maxFreeTime(eventTime: Int, k: Int, startTime: Array[Int], endTime: Array[Int]): Int = {
    val free = (startTime.head +: startTime.tail.zip(endTime).map { case (s, e) => s - e }) :+ (eventTime - endTime.last)
    free.zipWithIndex.foldLeft((0, 0)) { case ((maxFree, sum), (f, i)) =>
      val newSum = sum + f
      if (i < k) (maxFree, newSum)
      else {
        val newMaxFree = maxFree.max(newSum)
        (newMaxFree, newSum - free(i - k))
      }
    }._1
  }
}
