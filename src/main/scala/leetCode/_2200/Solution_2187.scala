package leetCode._2200

object Solution_2187 {
  def minimumTime(time: Array[Int], totalTrips: Int): Long = {
    lazy val sorted = time.toVector.sorted

    def check(t: Long): Boolean =
      sorted.takeWhile(_ <= t).map(t / _).sum >= totalTrips

    @scala.annotation.tailrec
    def f(lo: Long, hi: Long): Long = {
      lazy val mid = (hi + lo) >> 1
      if (lo + 1 >= hi) hi
      else if (check(mid)) f(lo, mid)
      else f(mid, hi)
    }

    f(0L, sorted.last * totalTrips.toLong * sorted.size)
  }
}
