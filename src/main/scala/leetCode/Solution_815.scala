package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_815 {
  def numBusesToDestination(routes: Array[Array[Int]], S: Int, T: Int): Int = S match {
    case T => 0
    case _ =>
      val flag = new mutable.HashSet[Int]()
      val q = new mutable.Queue[(Int, Int)]()
      val m = new mutable.HashMap[Int, mutable.HashSet[Int]]()
      q.enqueue((S, 0))
      routes.indices.foreach(i => routes(i).foreach(j => m(j).add(i)))
      while (q.nonEmpty) {
        val cur = q.front._1
        val cnt = q.front._2
        q.dequeue
        if (cur == T) return cnt
        m(cur).foreach(i => routes(i).foreach(j => {
          breakable {
            if (flag.contains(j)) break
          }
          flag.add(j)
          q.enqueue((j, cnt + 1))
        }))
      }
      -1
  }
}
