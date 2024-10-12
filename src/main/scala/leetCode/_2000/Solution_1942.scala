package leetCode._2000

object Solution_1942 {
  def smallestChair(times: Array[Array[Int]], targetFriend: Int): Int = {
    val targetArrive = times(targetFriend).head
    val timesSorted = times.sortBy(_.head)
    val available = scala.collection.mutable.PriorityQueue[Int]()(Ordering.by(-_))
    times.indices.foreach(available.+=)

    val pq = scala.collection.mutable.PriorityQueue[Array[Int]]()(Ordering.by(-_.head))

    @scala.annotation.tailrec
    def f(i: Int): Int = {
      while (pq.nonEmpty && pq.head.head <= timesSorted(i).head) available += pq.dequeue()(1)
      if (timesSorted(i)(0) == targetArrive) available.head
      else {
        pq += Array(timesSorted(i)(1), available.dequeue())
        f(i + 1)
      }
    }

    f(0)
  }
}
