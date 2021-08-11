package leetCode

import scala.collection.mutable

object Solution_1942 {
  def smallestChair(times: Array[Array[Int]], targetFriend: Int): Int = {

    val pq = mutable.PriorityQueue[(Int, Int)]().reverse
    val availableChair = mutable.PriorityQueue[Int](0 to times.length + 1: _*).reverse

    times
      .zipWithIndex
      .sortBy(_._1.head)
      .withFilter({ case (Array(_, _), _) => true; case _ => false })
      .foreach({ case (Array(start, end), friend) =>
        while (pq.nonEmpty && pq.head._1 <= start) {
          val (_, chair) = pq.dequeue()
          availableChair += chair
        }
        if (friend == targetFriend) return availableChair.head
        pq += (end -> availableChair.dequeue())
      })

    times.length - 1
  }
}
