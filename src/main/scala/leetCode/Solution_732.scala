package leetCode

import java.util

object Solution_732 {
  class MyCalendarThree() {
    val tm = new util.TreeMap[Int, Int]()

    def book(start: Int, end: Int): Int = {
      tm.put(start, tm.getOrDefault(start, 0) + 1)
      tm.put(end, tm.getOrDefault(end, 0) - 1)
      var mx = 0
      var active = 0
      tm.values().forEach(d => {
        active += d
        if (active > mx) mx = active
      })
      mx
    }

  }
}
