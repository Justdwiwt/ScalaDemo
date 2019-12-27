package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_853 {
  def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int = {
    var res = 0
    var cur = 0.0
    val q = new mutable.PriorityQueue[(Int, Int)]()
    position.indices.foreach(i => q.enqueue((position(i), speed(i))))
    while (q.nonEmpty) {
      val t = q.head
      q.dequeue
      val time = (target - t._1) / t._2
      breakable {
        if (time <= cur) break
      }
      cur = time
      res += 1
    }
    res
  }
}
