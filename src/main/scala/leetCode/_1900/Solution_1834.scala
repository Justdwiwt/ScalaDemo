package leetCode._1900

object Solution_1834 {
  def getOrder(tasks: Array[Array[Int]]): Array[Int] = {
    val sorted = tasks.zipWithIndex.sortBy(_._1.head)
    val n = sorted.length
    val pq = collection.mutable.PriorityQueue.empty[(Int, Int)]

    @scala.annotation.tailrec
    def f(time: Int = 0, i: Int = 0, res: List[Int] = Nil): Array[Int] =
      if (i != n || pq.nonEmpty) {
        if (i < n && sorted(i)._1.head <= time) {
          pq += ((-sorted(i)._1(1), -sorted(i)._2))
          f(time, i + 1, res)
        } else if (pq.isEmpty && i < n)
          f(sorted(i)._1.head, i, res)
        else {
          val (l, idx) = pq.dequeue
          f(time - l, i, -idx :: res)
        }
      } else res.reverse.toArray

    f()
  }
}
