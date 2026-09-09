package leetCode._4000

object Solution_3986 {
  def secondsBetweenTimes(startTime: String, endTime: String): Int = {
    def toSeconds(time: String): Int =
      time.split(":").map(_.toInt) match {
        case Array(h, m, s) => (h * 60 + m) * 60 + s
      }

    toSeconds(endTime) - toSeconds(startTime)
  }
}
