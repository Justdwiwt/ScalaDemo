package leetCode

object Solution_495 {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = timeSeries.length match {
    case 0 => 0
    case _ =>
      var total = 0
      (0 until timeSeries.length - 1).foreach(i => total += (timeSeries(i + 1) - timeSeries(i)).min(duration))
      total + duration
  }
}
