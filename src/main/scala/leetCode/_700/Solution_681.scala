package leetCode._700

object Solution_681 {
  def nextClosestTime(time: String): String = {
    val split = time.split(":")
    val st = split.mkString.toSet
    val hour = split.head.toInt
    val minute = split(1).toInt
    val minutes = hour * 60 + minute

    @scala.annotation.tailrec
    def f(cur: Int, limit: Int): Option[String] =
      if (cur > limit) None
      else {
        val h = f"${(cur % (24 * 60)) / 60}%02d"
        val m = f"${(cur % (24 * 60)) % 60}%02d"
        val timeStr = h + ":" + m
        if (st.contains(h.head) && st.contains(h(1)) && st.contains(m.head) && st.contains(m(1))) Some(timeStr)
        else f(cur + 1, limit)
      }

    f(minutes + 1, minutes + 24 * 60).get
  }
}
