package leetCode

import java.util
import java.util.Comparator

object Offer_058 {
  class MyCalendar() {
    val ts = new util.TreeSet[(Int, Int)](new Comparator[(Int, Int)]() {
      override def compare(o1: (Int, Int), o2: (Int, Int)): Int = if (o1._1 != o2._1) Integer.compare(o1._1, o2._1) else Integer.compare(o1._2, o2._2)
    })

    def book(start: Int, end: Int): Boolean = {
      val it = ts.iterator
      while (it.hasNext) {
        val curr = it.next()
        if ((curr._1 >= start && end > curr._1) || (curr._1 <= start && start < curr._2) || (curr._1 < end && end <= curr._2)) return false
      }
      ts.add(Tuple2(start, end))
    }
  }
}
