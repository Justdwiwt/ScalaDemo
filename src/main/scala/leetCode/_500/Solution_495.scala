package leetCode._500

object Solution_495 {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    if (timeSeries.isEmpty) return 0
    timeSeries.sliding(2)./:(0)((res, pair) => res + (pair.last - pair.head).min(duration)) + duration
  }
}
