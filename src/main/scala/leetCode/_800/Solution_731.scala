package leetCode._800

import scala.collection.mutable.ListBuffer

object Solution_731 {
  class MyCalendarTwo() {
    private val calendar: ListBuffer[(Int, Int)] = ListBuffer()
    private val overlaps: ListBuffer[(Int, Int)] = ListBuffer()

    def book(start: Int, end: Int): Boolean =
      if (overlaps.exists(overlap => start < overlap._2 && end > overlap._1)) false
      else {
        calendar.foreach(event => if (start < event._2 && end > event._1) overlaps.append((start.max(event._1), end.min(event._2))))
        calendar.append((start, end))
        true
      }
  }
}
