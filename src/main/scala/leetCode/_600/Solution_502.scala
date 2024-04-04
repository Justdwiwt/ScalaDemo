package leetCode._600

object Solution_502 {
  def findMaximizedCapital(k: Int, w: Int, profits: Array[Int], capital: Array[Int]): Int = {
    val pq = collection.mutable.PriorityQueue.empty[Int]

    @scala.annotation.tailrec
    def f(nonReady: Seq[(Int, Int)], rem: Int, cap: Int): Int =
      if (rem <= 0) cap else {
        lazy val (t, d) = nonReady.span(_._1 <= cap)
        pq ++= t.iterator.map(_._2)
        if (pq.isEmpty) cap
        else f(d, rem - 1, pq.dequeue + cap)
      }

    f(capital.zip(profits).toList.sorted, k, w)
  }
}
