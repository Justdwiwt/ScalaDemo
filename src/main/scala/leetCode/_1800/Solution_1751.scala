package leetCode._1800

object Solution_1751 {
  def preprocessEvents(events: Array[Array[Int]]): Unit = {
    val days = Array.tabulate(events.length << 1)(i => events(i >> 1)(i & 1)).distinct.sorted
    val daysMap = days.zipWithIndex.toMap
    val sortedEvents = events.sortBy(array => array(1))
    sortedEvents.indices.foreach(i => {
      sortedEvents(i)(0) = daysMap(sortedEvents(i)(0)) + 1
      sortedEvents(i)(1) = daysMap(sortedEvents(i)(1)) + 1
    })
  }

  def maxValue(events: Array[Array[Int]], k: Int): Int = {
    preprocessEvents(events)
    val lastDay = events.last(1)
    val bestValues = Array.fill(k + 1, lastDay + 1)(0)
    var eventIndex = 0
    (1 to lastDay).foreach(day => {
      while (eventIndex < events.length && events(eventIndex)(1) == day) {
        val Array(startDay, _, value) = events(eventIndex)
        (0 until k).foreach(eventN => bestValues(eventN + 1)(day) = (bestValues(eventN)(startDay - 1) + value).max(bestValues(eventN + 1)(day)))
        eventIndex += 1
      }
      (0 to k).foreach(eventN => bestValues(eventN)(day) = bestValues(eventN)(day - 1).max(bestValues(eventN)(day)))
    })
    bestValues.map(_.last).max
  }
}
