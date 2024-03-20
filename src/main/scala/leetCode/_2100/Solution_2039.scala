package leetCode._2100

import scala.collection.mutable

object Solution_2039 {
  def networkBecomesIdle(edges: Array[Array[Int]], patience: Array[Int]): Int = {
    val m = mutable.Map.empty[Int, mutable.ListBuffer[Int]]
    edges.foreach { case Array(from, to) =>
      m.getOrElseUpdate(from, mutable.ListBuffer.empty).append(to)
      m.getOrElseUpdate(to, mutable.ListBuffer.empty).append(from)
    }

    var res = 0
    val toVisit = mutable.Queue(m(0).map((_, 1)): _*)
    val visited = mutable.Set(m(0) :+ 0: _*)

    while (toVisit.nonEmpty) {
      val (curr, distance) = toVisit.dequeue()
      val lastRetryTimeLeft = (2 * distance - 1) / patience(curr) * patience(curr)
      res = res.max(distance * 2 + lastRetryTimeLeft)
      m(curr).foreach(next => {
        if (!visited.contains(next)) visited.add(next)
        toVisit.enqueue((next, distance + 1))
      })
    }
    res + 1
  }
}
