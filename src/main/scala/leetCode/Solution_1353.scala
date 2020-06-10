package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_1353 {
  def maxEvents(events: Array[Array[Int]]): Int = {
    val t = events.sorted((o1: Array[Int], o2: Array[Int]) => if (o1(1) != o2(1)) o1(1) - o2(1) else o1(0) - o2(0))
    val s = new mutable.HashSet[Int]()
    t.foreach(event => breakable {
      (event(0) to event(1)).foreach(i => {
        if (!s.contains(i)) {
          s.add(i)
          break()
        }
      })
    })
    s.size
  }
}
