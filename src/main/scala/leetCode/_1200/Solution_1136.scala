package leetCode._1200

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1136 {
  def minimumSemesters(n: Int, relations: Array[Array[Int]]): Int = {
    val adj = Array.fill(n + 1)(ArrayBuffer.empty[Int])
    val inDegree = Array.fill(n + 1)(0)

    relations.foreach(relation => {
      val v1 = relation.head
      val v2 = relation(1)
      adj(v1) += v2
      inDegree(v2) += 1
    })

    val queue = mutable.Queue.empty[Int]

    (1 to n).foreach(i => if (inDegree(i) == 0) queue.enqueue(i))

    if (queue.isEmpty) return -1

    var res = 0
    var leftNodeCount = n
    while (queue.nonEmpty) {
      val list = ArrayBuffer.empty[Int]
      while (queue.nonEmpty) list += queue.dequeue()

      leftNodeCount -= list.size
      res += 1

      list.foreach(adj(_).foreach(neighbor => {
        inDegree(neighbor) -= 1
        if (inDegree(neighbor) == 0) queue.enqueue(neighbor)
      }))
    }

    if (leftNodeCount > 0) -1 else res
  }
}
