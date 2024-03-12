package leetCode._2200

object Solution_2187 {
  def minimumTime(time: Array[Int], totalTrips: Int): Long = {
    var l = 1L
    val sorted = time.sorted
    var r = sorted.head * totalTrips.toLong
    while (l < r) {
      val m = (l + r) / 2L
      var sum = 0L
      time.foreach(sum += m / _)
      if (sum < totalTrips) l = m + 1
      else r = m
    }
    l
  }
}
