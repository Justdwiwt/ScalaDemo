package leetCode._1900

object Solution_1870 {
  def minSpeedOnTime(dist: Array[Int], hour: Double): Int = {
    def time(speed: Int): Double = {
      val ts = dist.map(_.toDouble / speed)
      ts.init.map(Math.ceil).sum + ts.last
    }

    @scala.annotation.tailrec
    def binarySearch(low: Int, high: Int, best: Int): Int =
      if (low > high) best
      else {
        val mid = low + (high - low) / 2
        if (time(mid) <= hour) binarySearch(low, mid - 1, mid)
        else binarySearch(mid + 1, high, best)
      }

    val mx = 10000000
    val res = binarySearch(1, mx, -1)
    if (res == -1) -1 else res
  }
}
