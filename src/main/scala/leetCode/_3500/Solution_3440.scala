package leetCode._3500

object Solution_3440 {
  def maxFreeTime(eventTime: Int, startTime: Array[Int], endTime: Array[Int]): Int = {
    val freeTimes = startTime.head +: startTime.tail.zip(endTime.init).map { case (s, e) => s - e } :+ (eventTime - endTime.last)
    val topThree = freeTimes.zipWithIndex.sortBy(-_._1).take(3).map(_._2)
    startTime.zip(endTime).zipWithIndex.foldLeft(0) { case (res, ((s, e), i)) =>
      val sz = e - s
      val condition = topThree.exists(idx => i != idx && i + 1 != idx && sz <= freeTimes(idx)) || sz <= freeTimes(topThree.last)
      if (condition) res.max(freeTimes(i) + sz + freeTimes(i + 1)) else res.max(freeTimes(i) + freeTimes(i + 1))
    }
  }
}
