package leetCode

import scala.Ordering._
import scala.collection.mutable

object Solution_895 {

  class FreqStack() {

    private val q = mutable.PriorityQueue[(Int, Int, Int)]()(by(x => (x._2, x._3)))
    private val m = mutable.HashMap[Int, Int]()
    var p = 0

    def push(x: Int): Unit = {
      m.put(x, m.getOrElse(x, 0) + 1)
      q.enqueue((x, m(x), p))
      p += 1
    }

    def pop(): Int = {
      val top = q.dequeue._1
      m(top) -= 1
      top
    }

  }

}

