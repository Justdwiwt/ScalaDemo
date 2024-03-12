package leetCode._1900

object Solution_1870 {
  def minSpeedOnTime(dist: Array[Int], hour: Double): Int = {
    var l = 1
    var r = 10000000
    while (l < r - 1) {
      val mid = (l + r) >>> 1
      if (check(dist, hour, mid)) r = mid
      else l = mid + 1
    }
    if (check(dist, hour, l)) l
    else if (check(dist, hour, r)) r
    else -1
  }

  def check(dist: Array[Int], hour: Double, speed: Int): Boolean = {
    var totalHour = 0.0
    dist.indices.foreach(i => {
      if (i < dist.length - 1) totalHour += (dist(i).toDouble / speed).ceil
      else totalHour += dist(i).toDouble / speed
      if (totalHour > hour) return false
    })
    totalHour <= hour
  }
}
