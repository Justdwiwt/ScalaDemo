package leetCode._800

import scala.collection.mutable

object Solution_731 {

  class MyCalendarTwo() {

    private val cal = new mutable.TreeMap[Int, Int]()

    def book(start: Int, end: Int): Boolean = {
      cal.put(start, cal.getOrElse(start, 0) + 1)
      cal.put(end, cal.getOrElse(end, 0) - 1)
      var active = 0
      cal.values.foreach(i => {
        active += i
        if (active >= 3) {
          cal.put(start, cal(start) - 1)
          cal.put(end, cal(end) + 1)
          if (cal(start) == 0) cal.remove(start)
          return false
        }
      })
      true
    }
  }

}
