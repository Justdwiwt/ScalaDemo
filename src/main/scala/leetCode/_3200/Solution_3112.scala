package leetCode._3200

import scala.collection.mutable

object Solution_3112 {
  def minimumTime(n: Int, edges: Array[Array[Int]], disappear: Array[Int]): Array[Int] = {
    val g = Array.fill(n)(mutable.ListBuffer.empty[(Int, Int)])
    edges.foreach { case Array(x, y, wt) =>
      g(x).append((y, wt))
      g(y).append((x, wt))
    }

    val arr = Array.fill(n)(-1)
    arr(0) = 0
    val pq = mutable.PriorityQueue[(Int, Int)]((0, 0))(Ordering.by(-_._1)) += ((0, 0))

    def updateDistance(dx: Int, x: Int): Unit = {
      if (dx > arr(x)) ()
      else g(x).foreach { case (y, wt) =>
        val newDis = dx + wt
        if (newDis < disappear(y) && (arr(y) < 0 || newDis < arr(y))) {
          arr(y) = newDis
          pq += ((newDis, y))
        }
      }
    }

    while (pq.nonEmpty) {
      val (dx, x) = pq.dequeue()
      updateDistance(dx, x)
    }

    arr
  }
}
