package leetCode._2100

import scala.collection.mutable

object Solution_2050 {
  def minimumTime(n: Int, relations: Array[Array[Int]], time: Array[Int]): Int = {
    val calcTimes = Array.ofDim[Int](n + 1)
    val incoming = mutable.Map.empty[Int, mutable.Set[Int]]
    val unknownIncoming = mutable.Map.empty[Int, mutable.Set[Int]]
    val outgoing = mutable.Map.empty[Int, mutable.Set[Int]]
    (1 to n).foreach(i => {
      incoming(i) = mutable.Set.empty
      unknownIncoming(i) = mutable.Set.empty
      outgoing(i) = mutable.Set.empty
    })
    val q = mutable.Queue.empty[Int]
    relations.foreach(relation => {
      incoming(relation(1)).add(relation.head)
      unknownIncoming(relation(1)).add(relation.head)
      outgoing(relation.head).add(relation(1))
    })
    (1 to n).foreach(i => if (incoming(i).isEmpty) q.enqueue(i))
    while (q.nonEmpty) {
      val course = q.dequeue()
      val in = incoming(course)
      calcTimes(course) = time(course - 1) + (if (in.isEmpty) 0 else in.map(calcTimes(_)).max)
      outgoing(course).foreach(out => {
        unknownIncoming(out).remove(course)
        if (unknownIncoming(out).isEmpty)
          q.enqueue(out)
      })
    }
    calcTimes.max
  }
}
