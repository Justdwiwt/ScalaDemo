package leetCode._1400

object Solution_1344 {
  def angleClock(hour: Int, minutes: Int): Double = {
    val t = (minutes * 6 - (hour % 12 * 30 + minutes / 2.0)).abs
    t.min(360 - t)
  }
}
